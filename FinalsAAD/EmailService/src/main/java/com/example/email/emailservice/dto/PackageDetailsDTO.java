package com.example.email.emailservice.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PackageDetailsDTO implements Serializable {
/*
    @Valid
    private String packageDetailsId;
    @NotNull(message = "Package Id cannot be null.")
    @NotBlank(message = "Package Id cannot be blank.")
    private String packageId;
    @NotNull(message = "Package Category cannot be null.")
    @NotBlank(message = "Package Category cannot be blank.")
    private String packageCategory;
    @NotNull(message = "Hotel ID cannot be null.")
    @NotBlank(message = "Hotel ID cannot be blank.")
    private String hotelId;
    @NotNull(message = "Vehicle ID cannot be null.")
    @NotBlank(message = "Vehicle ID cannot be blank.")
    private String vehicleId;
    private Date startDate;
    private Date endDate;
    @Positive(message = "Value cannot be negative.")
    private int noOfDays;
    @NotNull(message = "Travel Area cannot be null.")
    @NotBlank(message = "Travel Area cannot be blank.")
    private String travelArea;
    @Positive(message = "Value cannot be negative.")
    private int noOfAdults;
    @Positive(message = "Value cannot be negative.")
    private int noOfChildren;
    @Positive(message = "Value cannot be negative.")
    private int totalHeadCount;
    private boolean petsStatus;
    private boolean guideStatus;
    private String guideId;
    @Positive(message = "Value cannot be negative.")
    private double totalPackageValue;
    @NotNull(message = "User ID cannot be null.")
    @NotBlank(message = "User ID cannot be blank.")
    private String userId;
    @Positive
    private double paidValue;
    private String paymentImageLocation;


    private String remarks;
    private String name;
    private String email;
*/


    private String ownerFullName;
    private String ownerEmail;
    private String ownerCardNumber;
    private String paymentAmount;
    private String paymentDate;





}
