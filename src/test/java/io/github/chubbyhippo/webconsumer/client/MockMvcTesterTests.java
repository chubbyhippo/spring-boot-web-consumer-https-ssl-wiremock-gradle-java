package io.github.chubbyhippo.webconsumer.client;

import io.github.chubbyhippo.webconsumer.TestcontainersConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
@Testcontainers(disabledWithoutDocker = true)
@AutoConfigureMockMvc
class MockMvcTesterTests {

    @Autowired
    private MockMvcTester mockMvcTester;

    @Test
    @DisplayName("should get hello when call hello")
    void shouldGetHelloWhenCallHello() {
        mockMvcTester.get()
                .uri("/hello")
                .assertThat()
                .doesNotHaveFailed()
                .hasStatus2xxSuccessful()
                .body()
                .asString()
                .isEqualTo("Hello!");

    }
}
