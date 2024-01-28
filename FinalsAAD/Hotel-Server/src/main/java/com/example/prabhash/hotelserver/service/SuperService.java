package com.example.prabhash.hotelserver.service;


import com.example.prabhash.hotelserver.dto.SuperDto;
import com.example.prabhash.hotelserver.res.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService<T extends SuperDto, ID> {
    ResponseEntity<Response> add(T t);

    ResponseEntity<Response> update(T t);

    ResponseEntity<Response> search(ID id);

    ResponseEntity<Response> delete(ID id);

    ResponseEntity<Response> getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode,String msg,Object data);

}
