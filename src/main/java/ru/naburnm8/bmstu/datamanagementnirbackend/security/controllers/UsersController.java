package ru.naburnm8.bmstu.datamanagementnirbackend.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @Value("${app.adminSecretKey}")
    private String adminSecretKey;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(@RequestHeader("AdminKey") String adminKey) {
        if(!adminKey.equals(adminSecretKey)) {
            return ResponseEntity.badRequest().build();
        }
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username, @RequestHeader("AdminKey") String adminKey) {
        if(!adminKey.equals(adminSecretKey)) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Users> user = userService.getUserByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user, @RequestHeader("AdminKey") String adminKey) {
        if(!adminKey.equals(adminSecretKey)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username, @RequestHeader("AdminKey") String adminKey) {
        if(!adminKey.equals(adminSecretKey)) {
            return ResponseEntity.badRequest().build();
        }
        userService.deleteUserByUsername(username);
        return ResponseEntity.ok().build();
    }
}
