package com.phc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phc.entity.User;
import com.phc.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id) {
        System.out.println(userRepository.findSampleQuery("ewan"));
        return userRepository.findById(id);
    }

    public User createUser() {
        User user = new User();
        user.setFirstName("nonoy");
        user.setUsername("ewan");
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}