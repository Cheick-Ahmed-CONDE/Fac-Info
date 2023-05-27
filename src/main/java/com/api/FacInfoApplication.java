package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

public class FacInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacInfoApplication.class, args);
	}

}
