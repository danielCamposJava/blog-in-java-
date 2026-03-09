package com.example.blog.dto.rp.response;

import com.example.blog.dto.rp.request.UpdatePostResuest;
import com.example.blog.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record CreateUserResponse(

        UUID id,
        String email,
        String password,
        String userPassword) {

    public  static CreateUserResponse fromEntity(User user) {

        List<UpdatePostResuest> updatePostResuests = new ArrayList<>();
        return new CreateUserResponse(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getPassword());

    }
}
