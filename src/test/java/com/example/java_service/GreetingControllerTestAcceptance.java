package com.example.java_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static java.util.Map.of;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GreetingControllerTestAcceptance {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldGreetWithDefaultValue_whenNoNamePassed() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting",
                String.class)).contains("Hello, World!");
    }

    @Test
    void shouldGreetWithAName_whenNamePassed() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting?name={name}",
                String.class, of("name", "Bob"))).contains("Hello, Bob!");
    }
}
