package org.myApps.customerMicroService;

import org.myApps.customerMicroService.dto.CustomerRequestDTO;
import org.myApps.customerMicroService.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			CustomerService customerService) {
		return args -> {
			customerService.save(new CustomerRequestDTO( "c01","maria", "maria@info.io"));
			customerService.save(new CustomerRequestDTO( "c02","rubik", "rubik@cube.io"));
		};
	}
}
