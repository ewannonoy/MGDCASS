package com.phc.das.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phc.das.entity.Appointment;
import com.phc.das.repositories.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment Appointment) {
        return appointmentRepository.save(Appointment);
    }

    public Appointment updateAppointment(Appointment Appointment) {
        // TODO merge
        return appointmentRepository.save(Appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.delete(id);
    }
}
