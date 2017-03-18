package com.phc.das.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phc.das.entity.Branch;
import com.phc.das.repositories.BranchRepository;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    public Optional<Branch> getById(Integer id) {
        return branchRepository.findById(id);
    }

    public Branch createBranch(Branch Branch) {
        return branchRepository.save(Branch);
    }

    public Branch updateBranch(Branch Branch) {
        // TODO merge
        return branchRepository.save(Branch);
    }

    public void deleteBranch(Integer id) {
        branchRepository.delete(id);
    }
}
