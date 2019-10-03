package org.incode.messagerelay.spi.mq;

import org.incode.messagerelay.spi.mq.impl.RelayMq;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
        RelayMq.class
})
public class RelayMqModule {

}
