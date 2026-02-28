package service;


import Mapper.PostMapper;
import dto.rp.request.CreatePostRequest;
import dto.rp.request.UpdatePostResuest;
import dto.rp.response.PostResponse;
import entity.Post;
import expection.PostNotFoundExpection;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.PostRepository;

import java.util.UUID;
@Transactional
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

  public PostResponse create(CreatePostRequest request){

      Post post =  PostMapper.toEntity(request);
      Post saved = (Post) repository.save(post);

      return  PostMapper.toResponse(saved);
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
