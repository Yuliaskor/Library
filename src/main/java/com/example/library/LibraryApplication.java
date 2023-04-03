package com.example.library;

import com.example.library.user.User;
import com.example.library.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(
			UserRepository userRepository

	) {
		return args -> {
			User user = new User();
			user.setEmail("test");
			user.setFirstname("test");
			user.setPassword("test");
			userRepository.save(user);
		};
	}
}
