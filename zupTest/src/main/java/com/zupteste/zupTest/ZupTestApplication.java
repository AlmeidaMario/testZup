package com.zupteste.zupTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ZupTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZupTestApplication.class, args);
	}

}
