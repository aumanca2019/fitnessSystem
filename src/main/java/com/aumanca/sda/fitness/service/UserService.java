package com.aumanca.sda.fitness.service;

import com.aumanca.sda.fitness.dto.UserRequest;
import com.aumanca.sda.fitness.dto.UserResponse;
import com.aumanca.sda.fitness.exceptions.NotFoundException;
import com.aumanca.sda.fitness.mapper.UserMapper;
import com.aumanca.sda.fitness.model.User;
import com.aumanca.sda.fitness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userDetailsService")
@Transactional //all public methods have transactional context
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(UserRequest userRequest) {
        userRepository.save(userMapper.toEntity(userRequest));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserResponse getUserById(Long id) throws RuntimeException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NotFoundException.ErrorCode.USER_NOT_FOUND, "Couldn't find " +
                        "user"));
        return userMapper.toDto(user);
    }

}
