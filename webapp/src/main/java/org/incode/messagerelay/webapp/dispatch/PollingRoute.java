package org.incode.messagerelay.webapp.dispatch;

import org.apache.camel.builder.RouteBuilder;
import org.incode.messagerelay.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PollingRoute extends RouteBuilder {

    final AppConfig appConfig;

    public PollingRoute(final AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void configure() {
        from("timer:poll?period={{app.polling-period}}")
            .to("direct:poll");
    }

}
