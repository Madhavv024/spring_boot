package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@SpringBootApplication
public class HelloWorldApplication {


	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
