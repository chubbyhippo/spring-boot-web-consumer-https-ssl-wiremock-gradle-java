package io.github.chubbyhippo.webconsumer;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.ComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    public ComposeContainer composeContainer() {
        //noinspection resource
        return new ComposeContainer(new File("compose.yaml"))
                .withExposedService("wiremock",
                        9443,
                        Wait.forListeningPort())
                .withLocalCompose(true);
    }

    @Bean
    public DynamicPropertyRegistrar dynamicPropertyRegistrar(ComposeContainer compose) {
        return registry -> {
            registry.add("hello.host", () -> compose.getServiceHost("wiremock", 9443));
            registry.add("hello.port", () -> compose.getServicePort("wiremock", 9443));
        };
    }

}
