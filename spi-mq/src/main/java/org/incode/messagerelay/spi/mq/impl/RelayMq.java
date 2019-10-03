package org.incode.messagerelay.spi.mq.impl;

import org.apache.camel.Produce;
import org.incode.messagerelay.spi.Relay;
import org.incode.messagerelay.spi.RelayStatus;
import org.springframework.stereotype.Component;

@Component
public class RelayMq implements Relay {

    @Override
    public RelayStatus handle(String interactionDtoXml) {
        return RelayStatus.OK;
    }


}
