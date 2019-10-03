package org.incode.messagerelay.spi;

public interface Relay {
    RelayStatus handle(String interactionDtoXml);
}
