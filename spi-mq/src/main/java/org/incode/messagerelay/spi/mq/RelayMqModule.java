package org.incode.messagerelay.spi.mq;

import org.incode.messagerelay.spi.mq.impl.JaxbService;
import org.incode.messagerelay.spi.mq.impl.RelayMq;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
        RelayMq.class,
        RelayMqConfig.class,
        JaxbService.class
})
@EnableConfigurationProperties(RelayMqConfig.class)
public class RelayMqModule {

}
