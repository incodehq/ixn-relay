package org.incode.messagerelay.spi.mq.impl;

import org.apache.camel.builder.RouteBuilder;
import org.incode.messagerelay.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqRoute extends RouteBuilder {

    final AppConfig appConfig;

    public MqRoute(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void configure() throws Exception {

        from("direct:interaction")
         .to(String.format("activemq:%s", appConfig.getRelayMq().getQueueName()));
    }

}
