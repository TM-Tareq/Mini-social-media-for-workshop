package com.example.socialmedia.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponseDTO {
    private Long id;
    private String authorName;
    private String content;
    private LocalDateTime createdAt;
}
