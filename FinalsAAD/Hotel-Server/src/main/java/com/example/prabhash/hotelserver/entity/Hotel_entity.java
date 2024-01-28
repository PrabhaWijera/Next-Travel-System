package com.example.prabhash.hotelserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table
public class Hotel_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String hotelId;
    private  String packageId;
    private String hotelName;
    private String stars;
    private String hotelCategory;
    private String hotelLocation;
    private String hotelLocationWithCoordinates;

    private String hotelImageLocation;
    private String hotelContactEmail;
    private String hotelContact1;
    private String hotelContact2;
    private boolean isPetsAllowed;

    private double fullBoardWithACLuxuryRoomDouble;
    private double halfBoardWithACLuxuryRoomDouble;
    private double fullBoardWithACLuxuryRoomTriple;
    private double halfBoardWithACLuxuryRoomTriple;



    private double hotelFee;
    private String cancellationCriteria;
    private String remarks;

}
