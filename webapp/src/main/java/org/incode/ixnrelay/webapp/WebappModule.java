package org.incode.ixnrelay.webapp;

import org.incode.ixnrelay.spi.mq.RelayMqModule;
import org.incode.ixnrelay.webapp.config.AppConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RelayMqModule.class
})
@EnableConfigurationProperties(AppConfig.class)
public class WebappModule {
}
