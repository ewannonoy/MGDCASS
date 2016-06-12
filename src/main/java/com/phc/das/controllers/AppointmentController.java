package com.phc.das.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phc.das.dto.AppointmentDto;
import com.phc.das.entity.Appointment;
import com.phc.das.services.AppointmentService;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AppointmentDto>> getAppointments() {
        return new ResponseEntity<>(this.convertToDto(appointmentService.getAllAppointment()),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AppointmentDto> getAppointment(@PathVariable Long id) throws Exception {
        Optional<Appointment> appointment = appointmentService.getById(id);
        if (!appointment.isPresent()) {
            throw new Exception();
        }

        return new ResponseEntity<>(this.convertToDto(appointment.get()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<AppointmentDto>> createAppointment(
            @RequestBody AppointmentDto appointmentDto) {
        appointmentService.createAppointment(this.convertToEntity(appointmentDto));
        return new ResponseEntity<>(this.convertToDto(appointmentService.getAllAppointment()),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<List<AppointmentDto>> updateAppointment(
            @RequestBody AppointmentDto appointmentDto) {
        Appointment appointment = this.convertToEntity(appointmentDto);
        appointmentService.updateAppointment(appointment);
        return new ResponseEntity<>(this.convertToDto(appointmentService.getAllAppointment()),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @see https://github.com/jmnarloch/modelmapper-spring-boot-starter
     * @param appointment
     * @return AppointmentDto
     */
    private AppointmentDto convertToDto(Appointment appointment) {
        AppointmentDto appointmentDto = modelMapper.map(appointment, AppointmentDto.class);
        return appointmentDto;
    }

    private List<AppointmentDto> convertToDto(List<Appointment> appointments) {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        for (Appointment appointment : appointments) {
            appointmentDtos.add(this.convertToDto(appointment));
        }
        return appointmentDtos;
    }

    private Appointment convertToEntity(AppointmentDto appointmentDto) {
        Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
        return appointment;
    }
}

