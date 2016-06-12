package com.phc.das.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class AppointmentDto {

    private Long id;
    private String appointmentNo;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String remarks;
    private String encodedBy;
    private List<OperationDto> procedures;


}
