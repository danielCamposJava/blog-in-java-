package com.example.blog.service;

import com.example.blog.Mapper.PostMapper;
import com.example.blog.dto.rp.request.CreatePostRequest;
import com.example.blog.dto.rp.request.UpdatePostResuest;
import com.example.blog.dto.rp.response.PostResponse;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.expection.PostNotFoundExpection;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;


    public PostResponse create(CreatePostRequest request, String name) {

        User user = userRepository.findByUsername(name)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + name)
                );

        Post post = PostMapper.toEntity(request, user);

        return PostMapper.toResponse(
                postRepository.save(post)
        );
    }


    public PostResponse findById(UUID id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundExpection(
                                "Post not found with id: " + id
                        )
                );

        return PostMapper.toResponse(post);
    }


    public void delete(UUID id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundExpection(
                                "Post not found with id: " + id
                        )
                );

        post.delete(); // soft delete
    }


    public PostResponse update(
            UUID id,
            UpdatePostResuest request
    ) {

        Post post = postRepository.findById(id)
                .orElseThrow(() ->
                        new PostNotFoundExpection(
                                "Post not found with id: " + id
                        )
                );

        post.update(
                request.title(),
                request.content()
        );

        return PostMapper.toResponse(post);
    }
}