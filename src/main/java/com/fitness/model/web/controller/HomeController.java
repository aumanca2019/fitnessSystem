package com.fitness.model.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/home","/"})
    public String getHome() {
        return "home";
    }

    @RequestMapping("/about")
    public String getAbout() {
        return "about";
    }

    @RequestMapping("/contact")
    public String getContact() {
        return "contact";
    }

}
