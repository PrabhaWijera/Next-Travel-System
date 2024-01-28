package com.example.prabhash.packagedetailsserver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mail {
    private String  toMail;
    private String message;

    private String subject;

}
