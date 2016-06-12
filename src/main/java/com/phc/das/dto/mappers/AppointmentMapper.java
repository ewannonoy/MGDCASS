package com.phc.das.dto.mappers;

import org.modelmapper.PropertyMap;

import com.phc.das.dto.AppointmentDto;
import com.phc.das.entity.Appointment;

public class AppointmentMapper extends PropertyMap<Appointment, AppointmentDto> {

    @Override
    protected void configure() {
        System.out.println("asdsadsdd");
        skip().setProcedures(null);
    }
}

