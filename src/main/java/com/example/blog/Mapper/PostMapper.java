package com.example.blog.Mapper;

import com.example.blog.dto.rp.request.CreatePostRequest;
import com.example.blog.dto.rp.response.PostResponse;
import com.example.blog.entity.Post;

public class PostMapper {

  public  static Post toEntity(CreatePostRequest request){
     return  new Post(
             request.title(),
             request.content()
     );
  }

  public static PostResponse toResponse(Post post){
      return  new PostResponse(
              post.getId(),
              post.getTitle(),
              post.getContent(),
              post.getCreatedAt()
      );
  }
}
