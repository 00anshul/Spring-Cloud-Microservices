package com.product.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProjectProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectProductServiceApplication.class, args);
	}

}
