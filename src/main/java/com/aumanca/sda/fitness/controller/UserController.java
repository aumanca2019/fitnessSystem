package com.aumanca.sda.fitness.controller;

import com.aumanca.sda.fitness.dto.UserRequest;
import com.aumanca.sda.fitness.dto.UserResponse;
import com.aumanca.sda.fitness.model.User;
import com.aumanca.sda.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("api/users")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping
    public String createUser(@ModelAttribute UserRequest userRequest) {
        userService.save(userRequest);
        return "index";
    }
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.findAll();

        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable(required = true) Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") final Long id) {
        userService.delete(id);

    }
}
