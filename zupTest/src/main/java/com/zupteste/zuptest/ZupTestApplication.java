package com.zupteste.zuptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@SpringBootApplication
@EnableSpringDataWebSupport
public class ZupTestApplication {//NOPMD

	public static void main(final String[] args) {//NOPMD
		SpringApplication.run(ZupTestApplication.class, args);
	}



}
