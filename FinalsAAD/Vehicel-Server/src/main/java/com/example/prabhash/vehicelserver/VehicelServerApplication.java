package com.example.prabhash.vehicelserver;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class VehicelServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicelServerApplication.class, args);
        System.out.println("Vehicle-SERVER IS RUNNING!!!");
    }



}
