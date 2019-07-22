package com.fitness.model.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationController {

    @RequestMapping("/locations")
    public String getLocations() {
        return "locations";
    }
}
