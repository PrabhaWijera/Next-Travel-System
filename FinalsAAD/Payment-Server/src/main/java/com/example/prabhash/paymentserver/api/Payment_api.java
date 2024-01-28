package com.example.prabhash.paymentserver.api;


import com.example.prabhash.paymentserver.dto.Payment_dto;
import com.example.prabhash.paymentserver.res.Response;
import com.example.prabhash.paymentserver.service.custom.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("api/v1/Payment")

public class Payment_api {

    @Autowired
    private PaymentService paymentService;


    @GetMapping(path = "PGet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> get(@RequestParam("PayID") String PayID){
        System.out.println("payment search");
        return paymentService.search(PayID);
    }

    @PostMapping(path = "PSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody Payment_dto paymentDto){
        System.out.println("save payment in controller");
        return paymentService.save(paymentDto);
    }

    @PutMapping(path = "Pput",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody Payment_dto paymentDto){
        System.out.println("put payment");
        return paymentService.update(paymentDto);
    }

    @DeleteMapping(path = "Pdelet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("PayID") String PayID){
        System.out.println("PayID delete ok");
        return paymentService.delete(PayID);
    }


    @GetMapping(path = "/getAllPayments",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Response> getAllPayments() {
        // Return the data as a response
        return paymentService.getAll();
    }

}
