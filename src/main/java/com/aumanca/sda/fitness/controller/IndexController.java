package com.aumanca.sda.fitness.controller;


import com.aumanca.sda.fitness.dto.UserRequest;
import com.aumanca.sda.fitness.model.User;
import com.aumanca.sda.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller("/")
public class IndexController {



    @RequestMapping("/")
    public String getIndex() {
        return "home";
    }

    @RequestMapping("register")
    public String getRegister(Model model){
        model.addAttribute("userRequest",new UserRequest());
        return "register";
    }
   //  public String createNewUser(@Valid UserRequest userRequest){


}




