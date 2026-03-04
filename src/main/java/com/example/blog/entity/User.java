package com.example.blog.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table( name = "User")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id;

    @Column( nullable = false, unique = true)
    private String username;

    @Column( nullable = false)
    private String password;

    @Column( nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

}
