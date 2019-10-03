package org.incode.messagerelay.config;

import lombok.Data;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Primary;

@Primary
@ConfigurationProperties("app")
@Data
public class AppConfig {

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration pollingPeriod = Duration.ofSeconds(10);

    private final OutboxClient outboxClient = new OutboxClient();

    @Data
    public static class OutboxClient {
        private String base = "http://localhost:8080/restful/";
        private String username = "sven";
        private String password = "pass";
    }

    private final RelayMq relayMq = new RelayMq();
    @Data
    public static class RelayMq {
        private String queueName = "memberInteractionsQueue";
    }

}
