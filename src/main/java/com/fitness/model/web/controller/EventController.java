package com.fitness.model.web.controller;

import com.fitness.model.model.Event;
import com.fitness.model.model.User;
import com.fitness.model.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;


    @RequestMapping("/events")
    public String eventList(Model model) {
        Iterable<Event> events = eventService.findAll();
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/events/myEvents")
    public String myEventList(Model model, Principal principal) {
        if (principal != null) {
            User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
            Iterable<Event> events = eventService.findByUser(user);
            model.addAttribute("events", events);
            return "myevents";
        } else return "home";
    }
}
