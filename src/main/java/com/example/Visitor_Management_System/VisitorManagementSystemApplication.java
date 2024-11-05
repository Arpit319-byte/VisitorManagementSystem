package com.example.Visitor_Management_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VisitorManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitorManagementSystemApplication.class, args);
	}

}
