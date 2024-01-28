package com.example.prabhash.vehicelserver.service;

import com.example.prabhash.vehicelserver.dto.SuperDto;
import com.example.prabhash.vehicelserver.res.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SuperService <T extends SuperDto, ID> {


    ResponseEntity<Response>  search(String id);

    ResponseEntity<Response>  save(T t);

    ResponseEntity<Response>   update(T t);

    ResponseEntity<Response> delete(String id);

    ResponseEntity<Response> getAll();

    ResponseEntity<Response> createAndSendResponse(int statusCode,String msg,Object data);

}
