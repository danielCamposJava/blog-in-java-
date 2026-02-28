package Mapper;

import dto.rp.request.CreatePostRequest;
import dto.rp.response.PostResponse;
import entity.Post;

import javax.swing.text.html.parser.Entity;

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
