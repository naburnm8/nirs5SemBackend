package ru.naburnm8.bmstu.datamanagementnirbackend.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.services.UserService;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.util.AuthRequest;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.util.AuthResponse;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody AuthRequest request){
        Users user = userService.registerUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        Users user = userService.authenticate(request.getUsername(), request.getPassword());
        if (user != null) {
            String token = JwtUtil.generateToken(user);
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).build();
    }
}



