package com.example.ChatGpt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatGptApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChatGptApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println("Hello application started....");
	}

}
