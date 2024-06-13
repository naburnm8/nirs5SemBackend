package ru.naburnm8.bmstu.datamanagementnirbackend.security.util;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.services.CustomUserDetailsService;

import java.io.IOException;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;



}
