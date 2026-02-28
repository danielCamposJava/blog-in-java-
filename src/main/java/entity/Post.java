package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 5000)
    private  String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

   @PrePersist
    private  void prePersist(){
       this.createdAt = LocalDateTime.now();
   }
}
