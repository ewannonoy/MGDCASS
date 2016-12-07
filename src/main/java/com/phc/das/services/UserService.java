package com.phc.das.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phc.das.entity.User;
import com.phc.das.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdmin() {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setAdmin(true);
            user.setEnabled(true);
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setLastPasswordResetDate(LocalDateTime.now());
            userRepository.save(user);
        }

    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        // TODO merge
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
