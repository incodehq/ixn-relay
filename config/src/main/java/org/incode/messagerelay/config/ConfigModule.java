package org.incode.messagerelay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
        AppConfig.class
})
public class ConfigModule {

}
