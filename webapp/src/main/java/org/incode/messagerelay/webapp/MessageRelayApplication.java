package org.incode.messagerelay.webapp;

import org.incode.messagerelay.config.ConfigModule;
import org.incode.messagerelay.spi.mq.RelayMqModule;
import org.incode.messagerelay.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        ConfigModule.class,
        RelayMqModule.class
})
@EnableConfigurationProperties(AppConfig.class)
public class MessageRelayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageRelayApplication.class, args);
    }

}
