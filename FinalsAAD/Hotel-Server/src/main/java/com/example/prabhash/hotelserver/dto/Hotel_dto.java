package com.example.prabhash.hotelserver.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Hotel_dto implements Serializable,SuperDto {

    @Valid
    @NotNull(message = "Hotel Id cannot be null.")
    @NotBlank(message = "Hotel Id cannot be blank.")
    private String hotelId;

    private String packageId;
    @NotNull(message = "Hotel Name cannot be null.")
    @NotBlank(message = "Hotel Name cannot be blank.")
    private String hotelName;
    @NotNull(message = "Hotel Category cannot be null.")
    @NotBlank(message = "Hotel Category cannot be blank.")
    private String hotelCategory;

    private String stars;
    @NotNull(message = "Hotel Address cannot be null.")
    @NotBlank(message = "Hotel Address cannot be blank.")
    private String hotelLocation;

    private String hotelLocationWithCoordinates;
    private String hotelImageLocation;
    @NotNull(message = "Phone cannot be null.")
    @NotBlank(message = "Phone cannot be blank.")
    private String hotelContactEmail;
    @NotNull(message = "Phone cannot be null.")
    @NotBlank(message = "Phone cannot be blank.")
    private String hotelContact1;
    @NotNull(message = "Phone cannot be null.")
    @NotBlank(message = "Phone cannot be blank.")
    private String hotelContact2;
    private double fullBoardWithACLuxuryRoomDouble;
    private double halfBoardWithACLuxuryRoomDouble;
    private double fullBoardWithACLuxuryRoomTriple;
    private double halfBoardWithACLuxuryRoomTriple;
    private boolean isPetsAllowed;

    private double hotelFee;

    private String cancellationCriteria;
    private String remarks;


}
