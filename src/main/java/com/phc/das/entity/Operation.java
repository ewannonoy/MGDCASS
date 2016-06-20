package com.phc.das.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Operation {

    @Id
    @GeneratedValue
    private Long id;
    // TODO Generated value
    private String procedureNo;
    private String actualPrice;
    // @OneToMany
    // private List<String> doctors;

    @ManyToOne
    private Appointment appointment;

}
