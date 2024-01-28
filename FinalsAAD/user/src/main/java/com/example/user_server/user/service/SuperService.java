package com.example.user_server.user.service;



import com.example.user_server.user.dto.SuperDto;
import com.example.user_server.user.res.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService<T extends SuperDto, ID> {
    ResponseEntity<Response> add(T t);

    ResponseEntity<Response> update(T t);

    ResponseEntity<Response> delete(ID id);

    ResponseEntity<Response> search(ID id);

    ResponseEntity<Response> getAll();


}
