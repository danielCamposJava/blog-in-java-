package com.example.blog.controller;

import com.example.blog.dto.rp.request.CreatePostRequest;
import com.example.blog.dto.rp.request.UpdatePostResuest;
import com.example.blog.dto.rp.response.PostResponse;
import com.example.blog.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/{username}")
    public PostResponse save(
            @PathVariable String username,
            @RequestBody @Valid CreatePostRequest request
    ) {
        return postService.create(request, username);
    }

    @GetMapping("/{id}")
    public PostResponse findById(
            @PathVariable UUID id
    ) {
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    public PostResponse update(
            @PathVariable UUID id,
            @RequestBody @Valid UpdatePostResuest request
    ) {
        return postService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable UUID id
    ) {
        postService.delete(id);
    }
}