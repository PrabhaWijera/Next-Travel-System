package com.example.user_server.user.dto;


import com.example.user_server.user.entity.GENDER;
import com.example.user_server.user.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class User_dto implements Serializable ,SuperDto {

    private String userRole;
    @Valid
    @NotNull(message = "User Id cannot be null.")
    private String userId;
    @NotBlank(message = "Name cannot be blank.")
    private String name;
    @NotNull(message = "UserName cannot be null.")
    private String userName;
    @NotNull(message = "Password cannot be null.")
    @NotBlank(message = "Password cannot be blank.")
    private String userPassword;
    @NotNull(message = "NIC cannot be null.")
    @NotBlank(message = "NIC cannot be blank.")
    @Size(min = 10, max = 12, message = "NIC must be between 10 and 12 characters.")
    private String userNIC;

    private String userNICImageLocation;
    @Positive(message = "Age must be a positive number.")
    private int userAge;

    @NotNull(message = "Gender cannot be null.")
    private GENDER gender;
    @NotNull(message = "Email cannot be null.")
    @NotBlank(message = "Email cannot be blank.")
    private String userEmail;
    @NotNull(message = "Phone cannot be null.")
    @NotBlank(message = "Phone cannot be blank.")
    private String userPhone;
    @NotNull(message = "Address cannot be null.")
    @NotBlank(message = "Address cannot be blank.")
    private String userAddress;
    @NotNull(message = "Remarks cannot be null.")
    @NotBlank(message = "Remarks cannot be blank.")
    private String remarks;

    private String userImageLocation;

    private boolean isAuthenticated;
}
