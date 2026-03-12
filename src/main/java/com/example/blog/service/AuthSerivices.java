package com.example.blog.service;

import com.example.blog.entity.User;
import com.example.blog.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthSerivices {

    private  final UserRepository userRepository;
    private  final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthSerivices(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public  String register(
            String username,
            String password
    ){
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);

        return  jwtService.generateToken(username);
    }

    public  String login(
            String username,
            String password
    ) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        if (!passwordEncoder.matches(
                password,user.getPassword()
        )){

            throw new RuntimeException("Wrong password");
        }
        return  jwtService.generateToken(username);
    }
}
