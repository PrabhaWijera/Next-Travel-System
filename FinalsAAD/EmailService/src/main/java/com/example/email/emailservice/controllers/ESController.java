package com.example.email.emailservice.controllers;


import com.example.email.emailservice.dto.EmailDetails;
import com.example.email.emailservice.dto.PackageDetailsDTO;
import com.example.email.emailservice.response.Response;
import com.example.email.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/emails")
@CrossOrigin
public class ESController {
    @Autowired
    private EmailService emailService;
    @PostMapping(path = "/sendEmail",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> sendEmail(@RequestBody EmailDetails email){
        System.out.println("Email Details: "+email.toString());
       return emailService.sendEmail(email);

    }
    @PostMapping(path = "/sendPackageDetails",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>sendPackageDetails(@RequestBody PackageDetailsDTO packageDetailsDTO){
        System.out.println(packageDetailsDTO.toString());
        System.out.println("Email Details: "+packageDetailsDTO.toString());
        return emailService.sendPackageDetails(packageDetailsDTO);



    }
}
