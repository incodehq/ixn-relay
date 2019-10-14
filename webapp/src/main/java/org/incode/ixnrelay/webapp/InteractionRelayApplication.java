package org.incode.ixnrelay.webapp;

import org.apache.camel.zipkin.starter.CamelZipkin;
import org.incode.ixnrelay.spi.mq.RelayMqModule;
import org.incode.ixnrelay.webapp.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        WebappModule.class
})
public class InteractionRelayApplication {

    public static void main(String[] args) {
        SpringApplication.run(InteractionRelayApplication.class, args);
    }

}