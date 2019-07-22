package com.fitness.model.web.controller;

import com.fitness.model.model.User;
import com.fitness.model.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm(Model model, HttpServletRequest request){
        model.addAttribute("user",new User());
        try{
            Object flash = request.getSession().getAttribute("flash");
            model.addAttribute("flash", flash);

            request.getSession().removeAttribute("flash");
        }catch (Exception ex){
            //
        }
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user) throws NotFoundException {
        userService.save(user);
        return  "login";
    }

    @RequestMapping("/access_denied")
    public String accessDenied(){
        return "access_denied";
    }
}
