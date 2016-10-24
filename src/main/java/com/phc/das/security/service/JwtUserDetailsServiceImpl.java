package com.phc.das.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phc.das.entity.User;
import com.phc.das.repositories.UserRepository;
import com.phc.das.security.JwtUserFactory;

/**
 * Created by stephan on 20.03.16.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (!user.isPresent()) {
            if (username.equals("admin")) {
                User adminUser = new User();
                return JwtUserFactory.create(adminUser);
            } else {
                throw new UsernameNotFoundException(
                        String.format("No user found with username '%s'.", username));
            }
        } else {
            return JwtUserFactory.create(user.get());
        }
    }
}
