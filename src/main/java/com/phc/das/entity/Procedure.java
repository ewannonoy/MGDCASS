package com.phc.das.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Procedure {

    @Id
    @GeneratedValue
    private Long id;
    // TODO Generated value
    private String procedureNo;
    // @OneToMany
    // private List<String> doctors;

}
