package com.example.prabhash.packagedetailsserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.transform.sax.SAXResult;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PackageDetails_dto implements Serializable, SuperDTO {

    private String packageDetailsID;

    private String packageID;

    private String packageCategory;

    private int hotelID;
    private int vehicleID;

    private Date startDuration;

    private Date endDuration;


    private String nameGuide;

    private int noOfDays;

    private String travelArea;

    private int noOfAdults;

    private int noOfChildren;

    private int totalHeadCount;

    private boolean isPetsAllowed;

    private boolean isGuideNeeded;

    private String guideID;

    private double totalPackageValue;

    private String userID;

    private double packagePaidValue;

    private String remark;
}
