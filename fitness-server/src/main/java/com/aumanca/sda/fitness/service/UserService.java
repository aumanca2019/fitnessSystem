package com.aumanca.sda.fitness.service;

import com.aumanca.sda.fitness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //all public methods have transactional context
public class UserService {

    @Autowired
    private UserRepository repository;


    @Transactional(readOnly = true) // overrides general behavior
    public List findAll() {
        return repository.findAll();
    }
}
