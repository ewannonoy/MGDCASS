package com.phc.das.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phc.das.entity.Authority;
import com.phc.das.entity.Authority.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    public Optional<Authority> findByName(AuthorityName name);
}
