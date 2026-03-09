package com.example.blog.service;

import com.example.blog.Mapper.UserMapper;
import com.example.blog.dto.rp.request.CreateUserRequest;
import com.example.blog.dto.rp.request.UpdateUserRequest;
import com.example.blog.dto.rp.response.CreateUserResponse;
import com.example.blog.entity.User;
import com.example.blog.expection.PostNotFoundExpection;
import com.example.blog.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // CREATE
    public CreateUserResponse createUser(@Valid CreateUserRequest request) {

        User user = UserMapper.toEntity(request);
        User savedUser = userRepository.save(user);

        return UserMapper.toResponse(savedUser);
    }


    public CreateUserResponse findUserById(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundExpection("User with id " + id + " not found")
                );

        return UserMapper.toResponse(user);
    }

    public void delete(UUID id) {

        if (!userRepository.existsById(id)) {
            throw new PostNotFoundExpection("User with id " + id + " not found");
        }

        userRepository.deleteById(id);
    }


    public List<CreateUserResponse> findAll() {

        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }


    public CreateUserResponse updateUser(UUID id, @Valid UpdateUserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundExpection("User with id " + id + " not found")
                );


        user.setName(request.name());
        user.setEmail(request.email());

        User savedUser = userRepository.save(user);

        return UserMapper.toResponse(savedUser);
    }
}
