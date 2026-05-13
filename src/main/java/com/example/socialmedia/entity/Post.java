package com.example.socialmedia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorName;
    @Column(length = 280)
    private String content;
    private LocalDateTime createdAt;

    private boolean active = true;
}
