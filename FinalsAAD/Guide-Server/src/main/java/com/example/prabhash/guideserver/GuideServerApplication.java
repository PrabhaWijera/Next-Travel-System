package com.example.prabhash.guideserver;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;


@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GuideServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuideServerApplication.class, args);
        System.out.println("GUIDE-SERVER IS RUNNING!!!");
    }



}
