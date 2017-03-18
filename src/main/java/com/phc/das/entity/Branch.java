package com.phc.das.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Branch {

    @Id
    @GeneratedValue
    private Integer id;
    private String branchName;
    private String address;

}
