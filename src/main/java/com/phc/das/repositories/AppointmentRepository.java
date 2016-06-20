package com.phc.das.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phc.das.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findById(Long id);
}
