package org.incode.ixnrelay.webapp.dispatch;

import org.apache.camel.builder.RouteBuilder;
import org.incode.ixnrelay.webapp.config.AppConfig;
import org.springframework.stereotype.Component;

@Component
public class TracingRoute extends RouteBuilder {

    final AppConfig appConfig;

    public TracingRoute(final AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void configure() {

        switch (appConfig.getTracing().getTracingType()) {
            case NONE:
                break;
        }
    }

}
