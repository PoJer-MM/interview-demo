package com.pojer.controller;

import com.pojer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public String query() {
        return service.getUser();
    }

    @PostMapping
    public String save(@RequestParam String name) {
        return service.saveUser(name);
    }
}