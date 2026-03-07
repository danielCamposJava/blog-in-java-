package com.example.blog.controller;

import com.example.blog.dto.rp.request.CreatePostRequest;
import com.example.blog.dto.rp.request.UpdatePostResuest;
import com.example.blog.dto.rp.response.PostResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.blog.service.PostService;
import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    public  final PostService postService;
    @PostMapping
    public PostResponse save(@RequestBody @Valid CreatePostRequest request) throws Throwable {
        return postService.create(request);
    }

    @GetMapping("/findById{id}")
    public PostResponse findById(@PathVariable UUID id) throws Throwable {
        return  postService.findById(id);
    }

    @PostMapping("/Udate{id}")
    public  PostResponse update(
            @PathVariable UUID id ,
            @RequestBody @Valid UpdatePostResuest request
    ) throws Throwable {
       return  postService.update(id ,request);

    }

   @DeleteMapping("/Delete{id}")
    public void delete(@PathVariable UUID id){
        postService.delete(id);
   }
}
