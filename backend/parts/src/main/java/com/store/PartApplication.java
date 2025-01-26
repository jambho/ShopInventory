package com.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.store")
//@EnableJpaRepositories(basePackages = "com.store.repository")
public class PartApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartApplication.class, args);
	}

}
