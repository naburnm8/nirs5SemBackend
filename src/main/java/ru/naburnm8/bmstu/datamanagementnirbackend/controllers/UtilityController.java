package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Message;

@RestController
@RequestMapping("/api/connection")
public class UtilityController {
    @GetMapping
    public Message getConnection() {
        return new Message("borovik");
    }
    @GetMapping("/info")
    public Message getInfo() {
        return new Message("PostgreSQL API running on Windows 11");
    }
}
