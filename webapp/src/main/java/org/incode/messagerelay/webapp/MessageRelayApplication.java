package org.incode.messagerelay.webapp;

import org.incode.messagerelay.spi.mq.RelayMqModule;
import org.incode.messagerelay.webapp.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        RelayMqModule.class
})
@EnableConfigurationProperties(AppConfig.class)
public class MessageRelayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageRelayApplication.class, args);
    }

}
