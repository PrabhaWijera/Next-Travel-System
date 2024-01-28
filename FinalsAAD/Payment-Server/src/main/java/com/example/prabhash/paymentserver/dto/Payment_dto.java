package com.example.prabhash.paymentserver.dto;

import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Payment_dto implements Serializable, SuperDto {

    private String payID;

    private String ownerFullName;
    private String ownerEmail;
    private String ownerCardNumber;
    private String paymentDate;




    private String userID;
    private String packageDetailsID;

    private String paymentAmount;
    private String paymentImageLocation;

}
