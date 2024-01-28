package com.example.prabhash.packagedetailsserver.api;

import com.example.prabhash.packagedetailsserver.dto.Mail;
import com.example.prabhash.packagedetailsserver.dto.PackageDetails_dto;
import com.example.prabhash.packagedetailsserver.res.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/v1/emails")
@RestController
public class Emails {

    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping(path = "sendEail")
    public String sendEmail(@RequestBody Mail mailsDto){
        try{
            SimpleMailMessage message=new SimpleMailMessage();
            message.setSubject(mailsDto.getSubject());
            message.setTo(mailsDto.getToMail());
            message.setFrom("prabhashwijerathna2001@gmail.com");
            message.setText(mailsDto.getMessage());
            javaMailSender.send(message);
            return "Success";
        }catch (Exception e){
            return e.getMessage();
        }



    }
}
