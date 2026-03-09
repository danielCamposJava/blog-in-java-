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
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;
    @PostMapping("CreateUser")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request){
        return  userService.createUser(request);
    }

    @GetMapping("/FindByud{if}")
    public CreateUserResponse findByid(@RequestBody CreateUserRequest request){
        UUID id = null;
        return userService.findUserById(id);
    }

    @PostMapping("/Update{id}")
    public CreateUserResponse updateUser(
            @RequestBody UpdateUserRequest request,
            @PathVariable @Valid UpdateUserRequest request2
    ) throws Throwable{
      return  userService.updateUser( request2);
    }

    @DeleteMapping("/Delete{id}")
    public void delete(@PathVariable UUID id){
        userService.delete(id);
    }

}
