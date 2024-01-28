package com.example.prabhash.packagedetailsserver;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class PackageDetailsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackageDetailsServerApplication.class, args);
        System.out.println("PACKAGE-DETAILS-SERVER IS RUNNING!!!");
    }


}
