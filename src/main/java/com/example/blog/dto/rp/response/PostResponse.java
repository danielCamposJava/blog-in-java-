package com.example.blog.dto.rp.response;

import com.example.blog.entity.Post;
import com.example.blog.entity.Tag;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PostResponse(
        UUID id,
        String title,
        String content,
        String author,
        List<String> tags,
        LocalDateTime createdAt
) {

    public static PostResponse fromEntity(Post post) {

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