package ru.naburnm8.bmstu.datamanagementnirbackend.security.additionals.authmodels;

public class LoginResponse {
    private String token;
    private final String TYPE = "Bearer";
    private int id;
    private String username;
    private String role;

    public LoginResponse(String token, int id, String username, String role) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTYPE() {
        return TYPE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
