package com.example.apigateway;

import com.netflix.appinfo.MyDataCenterInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class ApiGatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
        System.out.println("API-GATE IS RUNNING!!!");


      int [] xr={1,2,4,5,8,65,2,5,45};

        Arrays.sort(xr);
        System.out.println(xr);



    }

}
