package com.example.prabhash.vehicelserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
@Builder
public class Vehicle_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicleID;

    private String packageId;

    private String vehicleBrand;



    private String vehicleCategory;

    private String vehicleName;

    private String fuelType;

    private String hybrid;

    private String fuelUsage;

    private String vehicleImg;

    private String vehicleInteriorImg;

    private String fee_forDay;


    private String seatCapacity;

    private String transmissionType;

    private String driverName;

    private String conNumber;

    private String driverlicenseImg;

    private String remarks;


//other

}
