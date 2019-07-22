package com.aumanca.sda.fitness.controller;

import com.aumanca.sda.fitness.dto.UserRequest;
import com.aumanca.sda.fitness.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register2")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    public String createUser(@ModelAttribute UserRequest userRequest) {
        userService.save(userRequest);
        return "login";
    }

}
