package org.incode.messagerelay.webapp;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SampleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:bar")
                .setBody(constant("Hello from Camel"))
                .to("activemq:foo");

        from("activemq:foo")
                .to("log:sample");
    }

}
