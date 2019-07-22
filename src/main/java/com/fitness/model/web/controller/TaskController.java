package com.fitness.model.web.controller;

import com.fitness.model.model.Task;
import com.fitness.model.model.User;
import com.fitness.model.service.TaskService;
import com.fitness.model.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;


    @RequestMapping( "/todo")
    public String taskList(Model model) {
        Iterable<Task> tasks = taskService.findAll();
        model.addAttribute("tasks",tasks);
        model.addAttribute("newTask", new Task());
        return "todo";
    }

    @PostMapping("/mark")
    public String toggleComplete(@RequestParam Long id) throws NotFoundException {
        taskService.toggleComplete(id);
        return "redirect:/todo";
    }

    @PostMapping("/tasks")
    public String addTask(@ModelAttribute Task task, Principal principal) {
        User user = (User)((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        task.setUser(user);
        taskService.save(task);
        return "redirect:/todo";
    }
}
