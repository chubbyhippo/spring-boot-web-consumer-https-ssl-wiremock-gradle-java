package io.github.chubbyhippo.webconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ssl.SslBundle;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Value("${hello.host}")
    private String host;

    @Value("${hello.port}")
    private int port;

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder, SslBundles sslBundles) {
        SslBundle sslBundle = sslBundles.getBundle("my-bundle");

        return builder.rootUri("https://" + host + ":" + port).sslBundle(sslBundle).build();
    }
}
