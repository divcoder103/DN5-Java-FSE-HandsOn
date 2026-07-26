package com.cognizant.jwt_handson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Welcome to JWT Handson";
    }

    @GetMapping("/countries")
    public String countries() {
        return "Countries API Accessed Successfully";
    }

    @GetMapping("/authenticate")
    public String authenticate() {
        return "Authentication Successful";
    }
}