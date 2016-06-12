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

import com.phc.das.dto.OperationDto;
import com.phc.das.entity.Operation;
import com.phc.das.services.OperationService;

@RestController
@RequestMapping("api/operations")
public class OperationController {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OperationService operationService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OperationDto>> getOperations() {
        return new ResponseEntity<>(this.convertToDto(operationService.getAllOperation()),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OperationDto> getOperation(@PathVariable Long id) throws Exception {
        Optional<Operation> operation = operationService.getById(id);
        if (!operation.isPresent()) {
            throw new Exception();
        }

        return new ResponseEntity<>(this.convertToDto(operation.get()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<OperationDto>> createOperation(
            @RequestBody OperationDto operationDto) {
        operationService.createOperation(this.convertToEntity(operationDto));
        return new ResponseEntity<>(this.convertToDto(operationService.getAllOperation()),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<List<OperationDto>> updateOperation(
            @RequestBody OperationDto operationDto) {
        Operation operation = this.convertToEntity(operationDto);
        operationService.updateOperation(operation);
        return new ResponseEntity<>(this.convertToDto(operationService.getAllOperation()),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOperation(@PathVariable Long id) {
        operationService.deleteOperation(id);
        return new ResponseEntity<>(HttpStatus.OK);
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

    private List<OperationDto> convertToDto(List<Operation> operations) {
        List<OperationDto> operationDtos = new ArrayList<>();
        for (Operation operation : operations) {
            operationDtos.add(this.convertToDto(operation));
        }
        return operationDtos;
    }

    private Operation convertToEntity(OperationDto operationDto) {
        Operation operation = modelMapper.map(operationDto, Operation.class);
        return operation;
    }
}

