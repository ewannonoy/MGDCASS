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
import com.phc.das.dto.OperationDto;
import com.phc.das.entity.Appointment;
import com.phc.das.entity.Branch;
import com.phc.das.entity.Operation;
import com.phc.das.services.AppointmentService;
import com.phc.das.services.BranchService;
import com.phc.das.services.OperationService;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private OperationService operationService;

    @Autowired
    private BranchService branchService;

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
    public ResponseEntity<AppointmentDto> createAppointment(
            @RequestBody AppointmentDto appointmentDto) throws Exception {
        Appointment newAppointment =
                appointmentService.createAppointment(this.convertToEntity(appointmentDto),
                        this.convertOperationToEntity(appointmentDto.getOperations()));
        return new ResponseEntity<>(this.convertToDto(newAppointment), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long id,
            @RequestBody AppointmentDto appointmentDto) throws Exception {
        Appointment oldAppointement = appointmentService.getById(id)
                .orElseThrow(() -> new Exception("No appointment found"));
        Appointment newAppointment = this.convertToEntity(appointmentDto);
        newAppointment.setId(id);
        newAppointment = appointmentService.updateAppointment(oldAppointement, newAppointment,
                this.convertOperationToEntity(appointmentDto.getOperations()));
        return new ResponseEntity<>(this.convertToDto(newAppointment), HttpStatus.OK);
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
        appointmentDto.setOperations(
                convertOperationToDto(operationService.getOperationsByAppointment(appointment)));

        return appointmentDto;
    }

    private List<AppointmentDto> convertToDto(List<Appointment> appointments) {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        for (Appointment appointment : appointments) {
            appointmentDtos.add(this.convertToDto(appointment));
        }
        return appointmentDtos;
    }

    private Appointment convertToEntity(AppointmentDto appointmentDto) throws Exception {
        Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
        Branch branch = branchService.getById(appointmentDto.getBranchId())
                .orElseThrow(() -> new Exception("No branch found"));
        appointment.setBranch(branch);
        return appointment;
    }

    /**
     * @see https://github.com/jmnarloch/modelmapper-spring-boot-starter
     * @param operation
     * @return OperationDto
     */
    private OperationDto convertToDto(Operation operation) {
        OperationDto operationDto = modelMapper.map(operation, OperationDto.class);
        return operationDto;
    }

    private List<OperationDto> convertOperationToDto(List<Operation> operations) {
        List<OperationDto> operationDtos = new ArrayList<>();
        for (Operation operation : operations) {
            operationDtos.add(this.convertToDto(operation));
        }
        return operationDtos;
    }

    private List<Operation> convertOperationToEntity(List<OperationDto> operationDtos) {
        List<Operation> operations = new ArrayList<>();
        for (OperationDto operationDto : operationDtos) {
            operations.add(this.convertToEntity(operationDto));
        }
        return operations;
    }

    private Operation convertToEntity(OperationDto operationDto) {
        Operation operation = modelMapper.map(operationDto, Operation.class);
        return operation;
    }
}

