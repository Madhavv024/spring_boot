package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
public class HelloWorldController {
    @GetMapping("/hey")
    public String helloWorld() {
        return "Hello world";
    }
}
