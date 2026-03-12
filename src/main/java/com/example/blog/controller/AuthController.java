package com.example.blog.controller;

import com.example.blog.dto.rp.request.LoginRequest;
import com.example.blog.dto.rp.response.AuthReponse;
import com.example.blog.dto.rp.response.RegisterRequest;
import com.example.blog.service.AuthSerivices;
import com.example.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private  final AuthSerivices service;

    @PostMapping("/Register")
    public AuthReponse register(@RequestBody RegisterRequest request){
        String token = service.register(
                request.username(),
                request.pasword());
        return  new AuthReponse(token);
    }

    @GetMapping("/login")
    public AuthReponse Login(
            @RequestBody LoginRequest request
    ){
        String token = service.login(
           request.username(),
           request.password()
        );
        return  new AuthReponse(token);
    }

}
