package io.github.chubbyhippo.webconsumer;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.ComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfig {

    @Bean
    ComposeContainer composeContainer(DynamicPropertyRegistry registry) {
        var compose = new ComposeContainer(new File("compose.yaml"))
                .withExposedService("wiremock-1",
                        9443,
                        Wait.forListeningPort())
                .withLocalCompose(true);
        registry.add("hello.port", () -> compose.getServicePort("wiremock-1", 9443));

        return compose;
    }


}
