package io.github.chubbyhippo.webconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestWebconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.from(WebconsumerApplication::main).with(TestWebconsumerApplication.class).run(args);
	}

}
