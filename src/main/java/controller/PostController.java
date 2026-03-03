package controller;


import dto.rp.request.CreatePostRequest;
import dto.rp.request.UpdatePostResuest;
import dto.rp.response.PostResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.PostService;

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

    @GetMapping("/{id}")
    public PostResponse findById(@PathVariable UUID id) throws Throwable {
        return  postService.findById(id);
    }

    @PostMapping("/{id}")
    public  PostResponse update(
            @PathVariable UUID id ,
            @RequestBody @Valid UpdatePostResuest request
    ) throws Throwable {
       return  postService.update(id ,request);

    }

   @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        postService.delete(id);
   }
}
