package com.example.prabhash.paymentserver;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class PaymentServerApplication {

    public static void main(String[] args) {
        System.out.println("PAYMENT-SERVER-START");
        SpringApplication.run(PaymentServerApplication.class, args);
        System.out.println("PAYMENT-SERVER-START");
    }


}
