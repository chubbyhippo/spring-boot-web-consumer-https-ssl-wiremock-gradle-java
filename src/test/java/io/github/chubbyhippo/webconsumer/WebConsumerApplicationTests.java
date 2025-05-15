package io.github.chubbyhippo.webconsumer;

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
class WebConsumerApplicationTests {

    @Test
    @DisplayName("should get hello when call hello")
    void shouldGetHelloWhenCallHello(@Autowired WebTestClient webTestClient) {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/hello").build())
                .exchange()
                .expectBody(String.class)
                .isEqualTo("Hello!");
    }

}
