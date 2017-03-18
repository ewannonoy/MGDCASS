package com.phc.das.services;

import java.util.List;
import java.util.Optional;

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

    public Appointment createAppointment(Appointment appointment) {
        appointment.setAppointmentNo(
                this.createAppointmentNo(appointmentRepository.save(appointment)));
        return appointmentRepository.save(appointment);
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

    public String createAppointmentNo(Appointment appointment) {
        final String prefix = "APP";
        String code = "XX";
        switch ("") {
            case "cleaning":
                code = "CL";
                break;
            default:
                code = "XX";
        }
        String appointmentNo = String.format("%s-%07d-%s", prefix, appointment.getId(), code);
        return appointmentNo;
    }
}
