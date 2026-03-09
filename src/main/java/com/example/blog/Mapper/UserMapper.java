package com.example.blog.Mapper;

import com.example.blog.dto.rp.request.CreateUserRequest;
import com.example.blog.dto.rp.response.CreateUserResponse;
import com.example.blog.entity.User;
import jakarta.validation.Valid;

public class UserMapper {

   public static User toEntity(@Valid CreateUserRequest request){

       User user = null;
       return new User(
               user.getEmail(),
               user.getPassword(),
               user.getName()
       );
   }
   public static CreateUserResponse toResponse(User user){
       return new CreateUserResponse(
               user.getId(),
               user.getEmail(),
               user.getName(),
               user.getPassword()
       );
   }

}
