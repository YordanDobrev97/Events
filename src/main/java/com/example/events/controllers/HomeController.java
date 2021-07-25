package com.example.events.controllers;

import com.example.events.interfaces.UsersService;
import com.example.events.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private UsersService usersService;

    public HomeController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String index() {
        this.usersService.create("Gosho", "123456789");
        return "index";
    }
}
