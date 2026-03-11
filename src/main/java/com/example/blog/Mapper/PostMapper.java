package com.example.blog.Mapper;

import com.example.blog.dto.rp.request.CreatePostRequest;
import com.example.blog.dto.rp.response.PostResponse;
import com.example.blog.entity.Post;
import com.example.blog.entity.Tag;
import com.example.blog.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static Post toEntity(
            CreatePostRequest request,
            User author
    ) {

        return new Post(
                author,
                request.title(),
                request.content()
        );

    }


    public static PostResponse toResponse(Post post) {

        List<String> tags = post.getTags()
                .stream()
                .map(Tag::getName)
                .collect(Collectors.toList());

        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor().getUsername(),
                tags,
                post.getCreatedAt()
        );

    }

}