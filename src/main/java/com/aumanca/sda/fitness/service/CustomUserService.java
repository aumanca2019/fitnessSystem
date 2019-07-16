package com.aumanca.sda.fitness.service;

import com.aumanca.sda.fitness.exceptions.NotFoundException;
import com.aumanca.sda.fitness.model.CustomUserDetails;
import com.aumanca.sda.fitness.model.User;
import com.aumanca.sda.fitness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =
                userRepository.findByUsername(username).orElseThrow(() -> {
                    return new NotFoundException(NotFoundException.ErrorCode.USER_NOT_FOUND, "User not found");
                });
        return new CustomUserDetails(user);
    }
}
