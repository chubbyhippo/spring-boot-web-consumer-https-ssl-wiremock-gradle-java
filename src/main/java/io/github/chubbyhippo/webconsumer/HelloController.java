package io.github.chubbyhippo.webconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    private final RestTemplate restTemplate;

    public HelloController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello")
    String getHello(){
        return restTemplate.getForObject("/hello", String.class);
    }

}
