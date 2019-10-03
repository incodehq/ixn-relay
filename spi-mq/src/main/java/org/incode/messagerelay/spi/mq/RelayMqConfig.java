package org.incode.messagerelay.spi.mq;

import lombok.Data;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;

@ConfigurationProperties("app.relay-mq")
@Data
public class RelayMqConfig {

    private String queueName = "memberInteractionsQueue";

}
