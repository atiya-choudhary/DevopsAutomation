package com.practice.eve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EveApplication.class, args);
	}
}