package com.example.blog.controller;

import com.example.blog.dto.rp.request.CreateUserRequest;
import com.example.blog.dto.rp.request.UpdateUserRequest;
import com.example.blog.dto.rp.response.CreateUserResponse;
import com.example.blog.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public CreateUserResponse createUser(
            @RequestBody @Valid CreateUserRequest request
    ) {
        return userService.createUser(request);
    }


    @GetMapping("/{id}")
    public CreateUserResponse findById(
            @PathVariable UUID id
    ) {
        return userService.findUserById(id);
    }


    @PutMapping("/{id}")
    public CreateUserResponse updateUser(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateUserRequest request
    ) {
        return userService.updateUser(id, request);
    }


    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable UUID id
    ) {
        userService.delete(id);
    }

}