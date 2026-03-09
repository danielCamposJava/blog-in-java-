package com.example.blog.Mapper;

import com.example.blog.dto.rp.request.CreateUserRequest;
import com.example.blog.dto.rp.response.CreateUserResponse;
import com.example.blog.entity.User;

public class UserMapper {

    public static User toEntity(CreateUserRequest request) {

        if (request == null) {
            throw new RuntimeException("CreateUserRequest is null");
        }

        User user = new User();

        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());

        return user;
    }

    public static CreateUserResponse toResponse(User user) {

        if (user == null) {
            throw new RuntimeException("User is null");
        }

        return new CreateUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword());
    }
}