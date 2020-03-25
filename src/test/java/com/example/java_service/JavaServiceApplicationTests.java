package com.example.java_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JavaServiceApplicationTests {

	@Autowired
	private GreetingController greetingController;

	@Test
	void contextLoads() {
		assertThat(greetingController).isNotNull();
	}

}
