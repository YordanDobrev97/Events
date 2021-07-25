package com.example.events.controllers;

import com.example.events.interfaces.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private UsersService usersService;

    public HomeController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ModelAndView index(ModelAndView model) {
        String password = "987654321";
        this.usersService.createUser("Administrator", password, "Admin");
        model.setViewName("index");
        return model;
    }
}
