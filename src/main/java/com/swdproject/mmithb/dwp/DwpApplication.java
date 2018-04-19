package com.swdproject.mmithb.dwp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DwpApplication {
	public static void main(String[] args) {
		SpringApplication.run(DwpApplication.class, args);
	}
}
