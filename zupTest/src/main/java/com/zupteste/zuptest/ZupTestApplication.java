package com.zupteste.zuptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ZupTestApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ZupTestApplication.class, args);
	}



}
