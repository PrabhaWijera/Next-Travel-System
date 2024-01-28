package com.example.user_server.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Guide_dto implements Serializable {

    private String guideID;

    private String guideName;

    private String guideAddress;

    private String guideAge;

    private String guideGender;

    private String guidePICImage;

    private String guideNICFrontIMG;

    private String guideNICRearIMG;

    private String guideIDscannedFrontIMG;

    private String guideIDscannedRearIMG;

    private String guideExperience;

    private int manDayValue;


    private String remark;

}
