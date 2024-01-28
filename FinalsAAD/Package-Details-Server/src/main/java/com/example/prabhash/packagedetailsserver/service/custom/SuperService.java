package com.example.prabhash.packagedetailsserver.service.custom;

import com.example.prabhash.packagedetailsserver.dto.SuperDTO;
import com.example.prabhash.packagedetailsserver.res.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService <T  extends SuperDTO,ID>{
    ResponseEntity<Response> search(String id);

    ResponseEntity<Response> save(T t);

    ResponseEntity<Response>  update(T t);

    ResponseEntity<Response>  delete(String id);

    ResponseEntity<Response>  getAll();

    ResponseEntity<Response> createAndSendResponse(int statusCode,String msg,Object data);

}
