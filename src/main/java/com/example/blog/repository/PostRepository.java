package com.example.blog.repository;

import com.example.blog.entity.Post;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    @Query("""
        SELECT p FROM Post p
        JOIN p.tags t
        WHERE t.name = :tag
    """)
    Page<Post> findByTag(@Param("tag") String tag, Pageable pageable);
}