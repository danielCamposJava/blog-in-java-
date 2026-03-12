package com.example.blog.controller;

import com.example.blog.dto.rp.response.AuthReponse;
import com.example.blog.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;


    @PostMapping("/register")
    public AuthReponse register(
            @RequestBody com.example.blog.dto.rp.request.RegisterRequest request
    ) {

        String token = service.register(
                request.username(),
                request.password()
        );

        return new AuthReponse(token);
    }


    @PostMapping("/login")
    public AuthReponse login(
            @RequestBody com.example.blog.dto.rp.request.LoginRequest request
    ) {

        String token = service.login(
                request.username(),
                request.password()
        );

        return new AuthReponse(token);
    }

}