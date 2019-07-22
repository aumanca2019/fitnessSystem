package com.fitness.model.web.controller;

import com.fitness.model.model.User;
import com.fitness.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrainerController {

    @Autowired
    private UserService userService;

    @RequestMapping("/trainers")
    public String getTrainers(Model model) {
        Iterable<User> trainers = userService.findAllTrainers();
        model.addAttribute("trainers", trainers);
        return "trainers";
    }
}
