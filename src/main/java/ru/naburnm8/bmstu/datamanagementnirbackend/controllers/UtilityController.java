package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Message;

@RestController
@RequestMapping("/api/connection")
public class UtilityController {
    @GetMapping
    public ResponseEntity<Message> getConnection() {

        return ResponseEntity.ok(new Message("borovik"));
    }
    @GetMapping("/info")
    public ResponseEntity<Message> getInfo() {
        return ResponseEntity.ok(new Message("PostgreSQL API Server running on Windows 11"));
    }
}
