package org.incode.ixnrelay.webapp;

import org.apache.camel.zipkin.starter.CamelZipkin;
import org.incode.ixnrelay.spi.mq.RelayMqModule;
import org.incode.ixnrelay.spi.mq.config.RelayMqConfig;
import org.incode.ixnrelay.spi.mq.impl.JaxbService;
import org.incode.ixnrelay.spi.mq.impl.RelayMq;
import org.incode.ixnrelay.webapp.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RelayMqModule.class
})
@EnableConfigurationProperties(AppConfig.class)
public class WebappModule {
}
