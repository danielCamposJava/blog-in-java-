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

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public  CreateUserResponse createUser(CreateUserRequest request)
    {
         User user =  UserMapper.toEntity(request);
         User savedUser = userRepository.save(user);

         return  UserMapper.toResponse(savedUser);
    }

    public  CreateUserResponse findUserById(UUID id)
    {
        User user = userRepository.findById(id).orElseThrow(
                () ->  new PostNotFoundExpection("Post with id " + id + " not found")
        );

        return  UserMapper.toResponse(user);
    }

    public void delete(UUID id ){
        if(!userRepository.existsById(id)){
            throw  new PostNotFoundExpection("Post with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public CreateUserResponse updateUser(@Valid UpdateUserRequest request)
    {
        User user =  UserMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return  UserMapper.toResponse(savedUser);

    }


}
