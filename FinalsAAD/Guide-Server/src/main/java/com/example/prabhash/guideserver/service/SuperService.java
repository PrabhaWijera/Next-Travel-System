package com.example.prabhash.guideserver.service;

import com.example.prabhash.guideserver.dto.SuperDto;
import com.example.prabhash.guideserver.res.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService  <T extends SuperDto, ID>{
    ResponseEntity<Response> search(String id);

    ResponseEntity <Response>save(T t);

    ResponseEntity <Response> update(T t);

    ResponseEntity<Response> findByGuideName(String guideName);

    ResponseEntity <Response> delete(String id);

    ResponseEntity <Response>getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);
}
