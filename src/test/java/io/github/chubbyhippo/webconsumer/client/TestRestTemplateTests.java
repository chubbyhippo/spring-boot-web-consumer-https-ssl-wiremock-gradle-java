package io.github.chubbyhippo.webconsumer.client;

import io.github.chubbyhippo.webconsumer.TestcontainersConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
@Testcontainers(disabledWithoutDocker = true)
class TestRestTemplateTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("should get hello when call hello")
    void shouldGetHelloWhenCallHello() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello!");
    }
}
