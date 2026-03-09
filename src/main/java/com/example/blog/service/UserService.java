package com.example.blog.service;

import com.example.blog.Mapper.UserMapper;
import com.example.blog.dto.rp.request.CreateUserRequest;
import com.example.blog.dto.rp.response.CreateUserResponse;
import com.example.blog.entity.User;
import com.example.blog.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public  CreateUserResponse createUser(CreateUserRequest request)
    {
         User user = UserMap
    }

}
