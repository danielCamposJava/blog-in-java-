package com.example.blog.dto.rp.request;

public class LoginRequest {
    public String username;
    public String password;

    public String password() {
        return password;
    }

    public String username() {
        return username;
    }
}
