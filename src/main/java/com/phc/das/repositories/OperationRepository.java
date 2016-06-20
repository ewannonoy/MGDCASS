package com.phc.das.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phc.das.entity.Appointment;
import com.phc.das.entity.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    Optional<Operation> findById(Long id);

    List<Operation> findByAppointment(Appointment appointment);

    void deleteByAppointment(Appointment newAppointment);
}
