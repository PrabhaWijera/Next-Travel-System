package com.example.email.emailservice.service;


import com.example.email.emailservice.response.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService <T,ID>{
    ResponseEntity<Response>getOTP(ID id);
    ResponseEntity<Response>createAndSendResponse(int statusCode,String message,Object data);

    void saveOTP(T t);


}
