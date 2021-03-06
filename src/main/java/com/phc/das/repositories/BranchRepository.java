package com.phc.das.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phc.das.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

    Optional<Branch> findById(Integer id);
}
