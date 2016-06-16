package com.phc.das.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phc.das.entity.Appointment;
import com.phc.das.entity.Operation;
import com.phc.das.repositories.AppointmentRepository;
import com.phc.das.repositories.OperationRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Appointment createAppointment(Appointment appointment, List<Operation> operations) {
        appointment = appointmentRepository.save(appointment);
        for (Operation operation : operations) {
            operation.setAppointment(appointment);
            operationRepository.save(operation);
        }
        return appointment;
    }

    @Transactional(rollbackFor = Exception.class)
    public Appointment updateAppointment(Appointment oldAppointment, Appointment newAppointment,
            List<Operation> operations) {
        // set unchangeable fields
        newAppointment.setAppointmentNo(oldAppointment.getAppointmentNo());
        operationRepository.deleteByAppointment(newAppointment);
        for (Operation operation : operations) {
            operation.setAppointment(newAppointment);
            operationRepository.save(operation);
        }
        return appointmentRepository.save(newAppointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.delete(id);
    }
}
