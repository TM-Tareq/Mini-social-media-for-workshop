package com.example.socialmedia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostRequestDTO {
    @NotBlank
    private String authorName;
    @NotBlank
    @Size(max = 280)
    private String content;
}
