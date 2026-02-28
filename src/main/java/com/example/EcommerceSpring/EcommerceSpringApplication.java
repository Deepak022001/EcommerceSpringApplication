package com.example.EcommerceSpring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class EcommerceSpringApplication {
	public static void main(String[] args) {
		Dotenv dotenv=Dotenv
				.configure()
				.load();
		dotenv.entries().forEach(entry->System.setProperty(entry.getKey(),entry.getValue()));
		SpringApplication.run(EcommerceSpringApplication.class, args);
	}
}
