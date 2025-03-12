package com.example.voting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.voting")
public class VotingSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(VotingSystemApplication.class, args);
	}
}
