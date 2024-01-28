package com.example.user_server.user.fiegn;

import com.example.user_server.user.dto.Payment_dto;
import com.example.user_server.user.res.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("PAYMENT-SERVICE")
public interface PayemtAuthfiegnInterface {



    @GetMapping(path = "PGet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("PayID") String PayID);

    @PostMapping(path = "PSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody Payment_dto paymentDto);


    @PutMapping(path = "Pput",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody Payment_dto paymentDto);

    @DeleteMapping(path = "Pdelet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("PayID") String PayID);



}
