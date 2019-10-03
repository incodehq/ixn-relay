package org.incode.messagerelay.webapp.dispatch;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.camel.Consume;
import org.apache.isis.schema.ixn.v1.InteractionDto;
import org.incode.messagerelay.spi.Relay;
import org.incode.messagerelay.spi.RelayStatus;
import org.incode.messagerelay.config.AppConfig;
import org.incode.messagerelay.spi.mq.impl.JaxbUtil;
import org.isisaddons.module.publishmq.dom.outboxclient.OutboxClient;
import org.springframework.stereotype.Component;

@Component
public class Dispatcher {

    private final AppConfig appConfig;
    private final List<Relay> relays;

    private OutboxClient outboxClient;

    public Dispatcher(AppConfig appConfig, List<Relay> relays) {
        this.appConfig = appConfig;
        this.relays = relays;
    }

    @PostConstruct
    public void init() {
        outboxClient = new OutboxClient();
        outboxClient.setBase(appConfig.getOutboxClient().getBase());
        outboxClient.setUsername(appConfig.getOutboxClient().getUsername());
        outboxClient.setPassword(appConfig.getOutboxClient().getPassword());

        outboxClient.init();
    }

    int i=0;
    // only consume when the predicate matches, eg when the message body is lower than 100
    @Consume(uri = "direct:tick")
    public void poll() {
        System.out.println("Tick " + (++i));

        final List<InteractionDto> interactions = outboxClient.pending();

        interactions.
                forEach(interactionDto -> {

                    String xml = JaxbUtil.toXml(interactionDto);
                    // pass interaction onto all downstream relays.
            // only if all succeed do we remove the interaction from upstream.
            final Optional<RelayStatus> anyFailed =
                    relays.stream()
                            .map(relay -> relay.handle(xml))
                            .filter(x -> x == RelayStatus.FAILED)
                            .findAny();
            if (!anyFailed.isPresent()) {
                outboxClient.delete(interactionDto.getTransactionId(), interactionDto.getExecution().getSequence());
            }
        });
    }

}
