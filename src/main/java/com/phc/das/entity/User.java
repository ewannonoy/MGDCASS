package com.phc.das.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private Boolean isAdmin;
    private UserType userType;

    public enum UserType {
        DENTIST, CUSTOMER
    }

}
