package com.aumanca.sda.fitness.controller;


import com.aumanca.sda.fitness.dto.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class IndexController {



    @RequestMapping("/")
    public String getIndex() {
        return "login";
    }

    @RequestMapping("register2")
    public String getRegister(Model model){
        model.addAttribute("userRequest",new UserRequest());
        return "register2";
    }
   //  public String createNewUser(@Valid UserRequest userRequest){


}




