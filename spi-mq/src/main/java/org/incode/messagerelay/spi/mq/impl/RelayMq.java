package org.incode.messagerelay.spi.mq.impl;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.isis.schema.ixn.v1.InteractionDto;
import org.incode.messagerelay.spi.Relay;
import org.incode.messagerelay.spi.RelayStatus;
import org.springframework.stereotype.Component;

@Component
public class RelayMq implements Relay {

    private final JaxbService jaxbService;

    @Produce(uri = "activemq:{{app.relay-mq.queue-name}}")
    ProducerTemplate producer;

    public RelayMq(JaxbService jaxbService) {
        this.jaxbService = jaxbService;
    }

    @Override
    public RelayStatus handle(InteractionDto interactionDto) {
        try {
            final String xml = jaxbService.toXml(interactionDto);
            producer.sendBody(xml);
            return RelayStatus.OK;
        } catch(Exception ex) {
            return RelayStatus.FAILED;
        }
    }


}
