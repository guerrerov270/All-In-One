package com.allinone.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AllinOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllinOneApplication.class, args);
	}

}
