package com.example.prabhash.hotelserver.advisor;

import com.example.prabhash.hotelserver.res.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component
public class Advisor {

    @Autowired
    private Response responseController;

    @ExceptionHandler({Exception.class})
    public Response handleException(Exception exception){
        responseController.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseController.setMessage("Sever threw an Exception"+exception.getLocalizedMessage());
        System.out.println(responseController.getMessage().toString());
        responseController.setData(null);
        return responseController;


    }

}
