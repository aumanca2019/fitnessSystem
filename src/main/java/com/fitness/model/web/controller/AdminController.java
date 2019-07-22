package com.fitness.model.web.controller;

import com.fitness.model.model.User;
import com.fitness.model.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    private String getUsers(Model model){
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/admin/users";
    }
    @PostMapping("/users/{id}/{role}")
    public String changeUserRole(@PathVariable(name = "id") Long id,
                                 @PathVariable(name = "role") Long role) throws NotFoundException {
        userService.changeRole(id, role);
        return "redirect:/admin/users";
    }
}
