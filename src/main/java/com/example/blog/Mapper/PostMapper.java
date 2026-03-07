package com.example.blog.Mapper;

import com.example.blog.dto.rp.request.CreatePostRequest;
import com.example.blog.dto.rp.response.PostResponse;
import com.example.blog.entity.Post;
import com.example.blog.entity.Tag;
import com.example.blog.entity.User;

import java.util.List;
public class PostMapper {

    public static Post toEntity(CreatePostRequest request){
        User author = null;
        return new Post(
                author,
                request.title(),
                request.content()
        );
    }

    public static PostResponse toResponse(Post post){

        List<String> tags = post.getTags()
                .stream()
                .map(Tag::getName)
                .toList();

        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor().getName(),
                tags,
                post.getCreatedAt()
        );
    }
}