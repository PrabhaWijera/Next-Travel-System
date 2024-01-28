package com.example.prabhash.guideserver.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Guide_entity {

    @MongoId
    @GeneratedValue(strategy = GenerationType.UUID)
    private String guideID;

    private String guideName;

    private String packageId;

    private String guideAddress;

    private String guideAge;

    private String guideGender;

    private String guidePICIMGLocation;

    private String guideNICIMGLocation;

    private String guideIDIMGLocation;

    private String guideExperience;

    private int manDayValue;


    private String remark;


}
