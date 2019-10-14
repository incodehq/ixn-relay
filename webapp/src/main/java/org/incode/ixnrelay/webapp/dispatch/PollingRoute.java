package org.incode.ixnrelay.webapp.dispatch;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.zipkin.ZipkinTracer;
import org.incode.ixnrelay.webapp.config.AppConfig;
import org.springframework.stereotype.Component;

@Component
public class PollingRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("timer:poll?period={{app.polling-period}}")
            .to("direct:poll");
    }

}
