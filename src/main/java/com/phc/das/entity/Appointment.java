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
    private String appointmentNo;
    // private LocalDateTime startTime;
    // private LocalDateTime endTime;
    private LocalDateTime appointmentDate;

    @Column(columnDefinition = "LONGTEXT")
    private String remarks;
    private String encodedBy;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private User customer;

}
