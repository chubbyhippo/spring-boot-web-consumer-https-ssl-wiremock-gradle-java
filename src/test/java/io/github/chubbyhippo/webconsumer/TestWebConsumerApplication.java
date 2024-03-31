package io.github.chubbyhippo.webconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestWebConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.from(WebConsumerApplication::main)
				.with(ContainersConfig.class)
				.run(args);
	}

}
