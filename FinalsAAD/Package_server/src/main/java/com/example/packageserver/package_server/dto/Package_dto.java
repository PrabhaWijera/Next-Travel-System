package com.example.packageserver.package_server.dto;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Package_dto implements Serializable,Super_dto{



    private String package_id;

    private String packageCategory;

    private  String vehical_Category;


    private String hotel_Category;

/*    private String user_list;*/

    /*private String guideID;*/


}
