package com.example.prabhash.paymentserver.service;

import com.example.prabhash.paymentserver.dto.SuperDto;
import com.example.prabhash.paymentserver.res.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService  <T extends SuperDto, ID>{
    ResponseEntity<Response> search(String id);

    ResponseEntity<Response>  save(T t);

    ResponseEntity<Response>   update(T t);

    ResponseEntity<Response>   delete(String id);

    ResponseEntity<Response>   getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);
}
