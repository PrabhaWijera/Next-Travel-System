package com.example.prabhash.vehicelserver.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Valid


    private String vehicleID;

    private String packageId;
    @NotNull(message = "Vehicle Model cannot be null")
    @NotBlank(message = "Vehicle Model cannot be blank")
    private String vehicleBrand;


    @NotNull(message = "Vehicle Name cannot be null")
    @NotBlank(message = "Vehicle Name cannot be blank")
    private String vehicleName;
    @NotNull(message = "Vehicle Category cannot be null")
    @NotBlank(message = "Vehicle Category cannot be blank")
    private String vehicleCategory;
    @NotBlank(message = "Fuel type cannot be blank")
    @NotNull(message = "Fuel type cannot be null")
    private String fuelType;

    private String hybrid;

    private String fuelUsage;

    private String vehicleImg;


    private String vehicleInteriorImg;

    private String fee_forDay;

    private String seatCapacity;
    @NotNull(message = "Transmission type cannot be null")
    @NotBlank(message = "Transmission type cannot be blank")
    private String transmissionType;

    private String driverName;

    private String conNumber;

    private String driverlicenseImg;

    private String remarks;


    //others



}
