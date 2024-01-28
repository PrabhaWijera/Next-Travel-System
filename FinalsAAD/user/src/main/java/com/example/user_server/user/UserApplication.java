package com.example.user_server.user;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class  UserApplication {


	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		System.out.println("USER-SERVER IS RUNNING!!!");
	}


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
