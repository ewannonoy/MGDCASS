package com.phc.das.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phc.das.entity.Operation;
import com.phc.das.repositories.OperationRepository;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public List<Operation> getAllOperation() {
        return operationRepository.findAll();
    }

    public Optional<Operation> getById(Long id) {
        return operationRepository.findById(id);
    }

    public Operation createOperation(Operation Operation) {
        return operationRepository.save(Operation);
    }

    public Operation updateOperation(Operation Operation) {
        // TODO merge
        return operationRepository.save(Operation);
    }

    public void deleteOperation(Long id) {
        operationRepository.delete(id);
    }
}
