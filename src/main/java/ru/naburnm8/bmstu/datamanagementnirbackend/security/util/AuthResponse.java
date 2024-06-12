package ru.naburnm8.bmstu.datamanagementnirbackend.security.util;

public class AuthResponse{
    private String token;

    public AuthResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}