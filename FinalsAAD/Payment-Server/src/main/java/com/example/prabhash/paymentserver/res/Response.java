package com.example.prabhash.paymentserver.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Response {
    private int statusCode;
    private String message;
    private Object data;
}
