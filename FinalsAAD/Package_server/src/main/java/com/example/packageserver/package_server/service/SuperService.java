package com.example.packageserver.package_server.service;

import com.example.packageserver.package_server.dto.Super_dto;
import com.example.packageserver.package_server.res.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService <T extends Super_dto,ID>{
    ResponseEntity<Response>  search(String id);

    ResponseEntity<Response>  save(T t);

    ResponseEntity<Response>   update(T t);

    ResponseEntity<Response>   delete(String id);

    ResponseEntity<Response>   getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);
}
