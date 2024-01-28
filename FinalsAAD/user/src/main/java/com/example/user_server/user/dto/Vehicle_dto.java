package com.example.user_server.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Vehicle_dto implements Serializable,SuperDto{

    private String vehicleID;

    private String vehicleBrand;

    private String vehicleCategory;

    private String fuelType;

    private String hybrid;

    private String fuelUsage;

    private String vehicleImg;


    private String vehicleInteriorImg;



    private String seatCapacity;

    private String transmissionType;

    private String driverName;

    private String conNumber;

    private String driverlicenseImg;

    private String remarks;


    //others



}
