package org.incode.messagerelay.webapp.dispatch;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.camel.Consume;
import org.apache.isis.schema.ixn.v1.InteractionDto;
import org.incode.messagerelay.spi.Relay;
import org.incode.messagerelay.spi.RelayStatus;
import org.incode.messagerelay.webapp.config.AppConfig;
import org.isisaddons.module.publishmq.dom.outboxclient.OutboxClient;
import org.springframework.stereotype.Component;

@Component
public class Dispatcher {

    private final AppConfig appConfig;
    private final List<Relay> relays;

    public Dispatcher(
            final AppConfig appConfig,
            final List<Relay> relays) {
        this.appConfig = appConfig;
        this.relays = relays;
    }

    private OutboxClient outboxClient;

    @PostConstruct
    public void init() {
        outboxClient = new OutboxClient();
        outboxClient.setBase(appConfig.getOutboxClient().getBase());
        outboxClient.setUsername(appConfig.getOutboxClient().getUsername());
        outboxClient.setPassword(appConfig.getOutboxClient().getPassword());

        outboxClient.init();
    }

    @Consume(uri = "direct:poll")
    public void poll() {
        final List<InteractionDto> interactions = outboxClient.pending();
        interactions.forEach(this::dispatchToAllThenDelete);
    }

    /**
     * Pass interaction onto all downstream relays.
     *
     * <p>
     *   Only if all succeed do we remove the interaction from upstream.
     * </p>
     */
    private void dispatchToAllThenDelete(InteractionDto interactionDto) {
        final Optional<RelayStatus> anyFailed =
                relays.stream()
                        .map(relay -> relay.handle(interactionDto))
                        .filter(x -> x == RelayStatus.FAILED)
                        .findAny();
        final boolean noneFailed = !anyFailed.isPresent();
        if (noneFailed) {
            outboxClient.delete(interactionDto.getTransactionId(), interactionDto.getExecution().getSequence());
        }
    }

}
