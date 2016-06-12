package com.phc.das.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;
    // TODO Generated value
    private String appointmentNo;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Column(columnDefinition = "LONGTEXT")
    private String remarks;
    private String encodedBy;

    @ManyToOne
    private Branch branch;

    // @OneToMany(targetEntity = Procedure.class)
    // private List<Procedure> procedures;

}
