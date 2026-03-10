package com.example.blog.service;

import com.example.blog.Mapper.PostMapper;
import com.example.blog.dto.rp.request.CreatePostRequest;
import com.example.blog.dto.rp.request.UpdatePostResuest;
import com.example.blog.dto.rp.response.PostResponse;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.expection.PostNotFoundExpection;
import com.example.blog.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.blog.repository.PostRepository;

import java.util.UUID;
@Transactional
@Service
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository repository;

  public PostResponse create(CreatePostRequest request, String username){

      User user = userRepository.findByUsername(username)
              .orElseThrow(() -> new  RuntimeException("User not found"));

      Post post = PostMapper.toEntity(request, user);

      userRepository.save(user);

      return  PostMapper.toResponse(repository.save(post));
  }

  public PostResponse findById(UUID id) throws Throwable {
      Post post = (Post) repository.findById(id).orElseThrow(
              () -> new PostNotFoundExpection("Post not found wit id :" + id)
      );

      return  PostMapper.toResponse(post);
  }

  public  void delete(UUID id ){
      if (!repository.existsById(id)) {
          throw  new PostNotFoundExpection("Post not found with id " + id );
      }
      repository.deleteById(id);
  }

   public PostResponse update(UUID id , UpdatePostResuest request) throws Throwable {
       Post post = (Post) repository.findById(id)
               .orElseThrow(() ->
                       new PostNotFoundExpection("Post not found with id: " + id)
               );

       post.update(request.title(), request.content());

       Post updated = (Post) repository.save(post);
       return PostMapper.toResponse(updated);
   }
}
