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
@RequestMapping("/register")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    public String createUser(@ModelAttribute UserRequest userRequest) {
        userService.save(userRequest);
        return  "index";
    }

}
