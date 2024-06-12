package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/connection")
public class UtilityController {
    @GetMapping
    public String getConnection() {
        return "borovik";
    }
    @GetMapping("/info")
    public String getInfo() {
        return "Tech Shop database running on Windows (PostgreSQL)";
    }
}
