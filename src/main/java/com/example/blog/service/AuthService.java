package com.example.blog.service;

import com.example.blog.entity.User;
import com.example.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final com.example.blog.service.JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public String register(
            String username,
            String password
    ) {

        User user = new User();

        user.setUsername(username);
        user.setPassword(
                passwordEncoder.encode(password)
        );

        userRepository.save(user);

        return jwtService.generateToken(username);
    }


    public String login(
            String username,
            String password
    ) {

        User user = userRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );

        if (!passwordEncoder.matches(
                password,
                user.getPassword()
        )) {
            throw new RuntimeException("Wrong password");
        }

        return jwtService.generateToken(
                username
        );
    }
}