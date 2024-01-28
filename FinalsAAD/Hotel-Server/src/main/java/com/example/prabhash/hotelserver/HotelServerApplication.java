package com.example.prabhash.hotelserver;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class HotelServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelServerApplication.class, args);
        System.out.println("HOTEL-SERVER IS RUNNING!!!");
    }



}
