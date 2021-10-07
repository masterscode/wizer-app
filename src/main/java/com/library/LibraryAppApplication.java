package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.library.repositories")
public class LibraryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAppApplication.class, args);
	}

}
