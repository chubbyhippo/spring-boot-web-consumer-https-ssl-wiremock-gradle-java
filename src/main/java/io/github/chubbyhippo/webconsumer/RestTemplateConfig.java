package io.github.chubbyhippo.webconsumer;

import org.springframework.boot.ssl.SslBundle;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder, SslBundles sslBundles) {
        SslBundle sslBundle = sslBundles.getBundle("my-bundle");
        return builder.rootUri("https://localhost:9443").setSslBundle(sslBundle).build();
    }
}
