package com.example.prabhash.guideserver.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Guide_dto implements Serializable, SuperDto {
    @Valid
    @NotNull(message = "Guide Id cannot be null.")
    @NotBlank(message = "Guide Id cannot be blank.")
    private String guideID;

    private String packageId;
    @NotBlank(message = "Name cannot be blank.")
    @NotNull(message = "Name cannot be null.")
    private String guideName;
    @NotBlank(message = "Address cannot be blank.")
    @NotNull(message = "Address cannot be null.")
    private String guideAddress;
    @NotNull(message = "Age cannot be null.")

    private String guideAge;
    @NotNull(message = "Phone cannot be null.")
    @NotBlank(message = "Phone cannot be blank.")
    private String guideGender;

    private String guidePICIMGLocation;

    private String guideNICIMGLocation;

    private String guideIDIMGLocation;

    private String guideExperience;

    private int manDayValue;


    private String remark;






}
