package io.github.chubbyhippo.webconsumer.client;

import io.github.chubbyhippo.webconsumer.TestcontainersConfiguration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
@Testcontainers(disabledWithoutDocker = true)
@Disabled
class WebTestClientTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("should get hello when call hello")
    void shouldGetHelloWhenCallHello() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/hello").build())
                .exchange()
                .expectBody(String.class)
                .isEqualTo("Hello!");
    }

}
