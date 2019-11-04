package org.incode.ixnrelay.webapp.config;

import lombok.Data;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;

@ConfigurationProperties("app")
@Data
public class AppConfig {

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration pollingPeriod = Duration.ofSeconds(10);

    private final OutboxClient outboxClient = new OutboxClient();

    @Data
    public static class OutboxClient {
        /**
         * The base URL of the webapp that hosts the <tt>OutboxEventsService</tt> REST API.
         */
        private String base = "http://localhost:8080/restful/";
        /**
         * The user name to invoke the {@link #getBase() REST API}
         */
        private String username = "sven";
        /**
         * The corresponding password for the {@link #getUsername() user}.
         */
        private String password = "pass";
    }

    public enum TracingType {
        NONE,
    }

    private final Tracing tracing = new Tracing();
    @Data
    public static class Tracing {
        private TracingType tracingType = TracingType.NONE;
    }
}
