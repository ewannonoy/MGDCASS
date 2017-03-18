package com.phc.das.dto;

import com.phc.das.entity.User.UserType;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String username;
    // private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String birthDate;
    private UserType userType;
    private boolean admin;
}
