package io.github.chubbyhippo.webconsumer.client;

import io.github.chubbyhippo.webconsumer.TestcontainersConfiguration;
import io.github.chubbyhippo.webconsumer.WebConsumerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestWebConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.from(WebConsumerApplication::main)
				.with(TestWebConsumerApplication.class)
				.with(TestcontainersConfiguration.class)
				.run(args);
	}

}
