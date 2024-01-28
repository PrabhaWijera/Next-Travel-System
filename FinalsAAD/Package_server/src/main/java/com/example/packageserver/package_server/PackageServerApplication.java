package com.example.packageserver.package_server;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class PackageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackageServerApplication.class, args);
        System.out.println("PACKAGE-SERVER IS RUNNING!!!");
    }



}
