package com.phc.das.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phc.das.entity.User;
import com.phc.das.repositories.UserRepository;

@Service
public class SearchService {

    @Autowired
    private UserRepository userRepository;

    public List<User> searchCustomer(String search) {
        return userRepository
                .findByFirstNameStartsWithIgnoreCaseOrLastNameStartsWithIgnoreCase(search, search);
    }
}
