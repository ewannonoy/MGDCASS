package com.phc.das.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNumber;
    private boolean enabled = true;
    private LocalDate birthDate;
    private UserType userType;
    @NotNull
    private LocalDateTime lastPasswordResetDate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;

    public enum UserType {
        DENTIST, CUSTOMER
    }

}
