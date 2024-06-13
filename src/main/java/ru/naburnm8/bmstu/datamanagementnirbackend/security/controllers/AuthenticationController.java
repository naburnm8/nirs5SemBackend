package ru.naburnm8.bmstu.datamanagementnirbackend.security.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.additionals.JwtUtils;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.additionals.authmodels.LoginRequest;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.additionals.authmodels.LoginResponse;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.additionals.authmodels.RegisterRequest;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.repositories.UserRepository;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.services.UserDetailsImplementation;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();
        return ResponseEntity.ok(new LoginResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getAuthorities().toString()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        if(userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        Users user = new Users();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(registerRequest.getRole());
        userRepository.save(user);

        return ResponseEntity.ok("User " + user.getUsername() + " registered successfully");
    }
}
