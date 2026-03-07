package com.example.blog.repository;

import com.example.blog.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    @Query("""
        SELECT p FROM Post p
        JOIN p.tags t
        WHERE t.name = :tag
    """)
    Page<Post> findByTag(@Param("tag") String tag, Pageable pageable);
}