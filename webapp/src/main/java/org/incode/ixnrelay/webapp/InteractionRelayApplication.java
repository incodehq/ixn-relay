package org.incode.ixnrelay.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        WebappModule.class
})
public class InteractionRelayApplication {

    public static void main(String[] args) {
        SpringApplication.run(InteractionRelayApplication.class, args);
    }

}
