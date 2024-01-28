package com.example.uploads.uploadserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UploadServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadServerApplication.class, args);
        System.out.println("UPLOAD IMAGE SERVER RUNNING ");
    }

}
