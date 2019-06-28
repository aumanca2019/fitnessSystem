package com.aumanca.sda.fitness.service;

import com.aumanca.sda.fitness.dto.UserRequest;
import com.aumanca.sda.fitness.dto.UserResponse;
import com.aumanca.sda.fitness.mapper.UserMapper;
import com.aumanca.sda.fitness.model.User;
import com.aumanca.sda.fitness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //all public methods have transactional context
public class UserService {

    private UserRepository repository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void save(UserRequest userRequest) {
        repository.save(userMapper.toEntity(userRequest));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public UserResponse getUserById(Long id) throws RuntimeException {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Couldn't find a User with id: " + id));

        return userMapper.toDto(user);
    }

}
