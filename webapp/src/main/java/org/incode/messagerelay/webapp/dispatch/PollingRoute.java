package org.incode.messagerelay.webapp.dispatch;

import org.apache.camel.builder.RouteBuilder;
import org.incode.messagerelay.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PollingRoute extends RouteBuilder {


    @Autowired
    AppConfig appConfig;

    @Override
    public void configure() throws Exception {

        from(String.format(
                "timer:poll?period=%ds",
                appConfig.getPollingPeriod().getSeconds())
            )
            .to("direct:tick"); // consumed by Processor
    }

}
