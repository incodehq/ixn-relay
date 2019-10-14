package org.incode.ixnrelay.spi.mq;

import org.incode.ixnrelay.spi.mq.config.RelayMqConfig;
import org.incode.ixnrelay.spi.mq.impl.JaxbService;
import org.incode.ixnrelay.spi.mq.impl.RelayMq;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
        RelayMq.class,
        JaxbService.class
})
@EnableConfigurationProperties(RelayMqConfig.class)
public class RelayMqModule {

}
