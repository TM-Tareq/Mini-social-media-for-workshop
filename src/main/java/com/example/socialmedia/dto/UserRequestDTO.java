package com.example.socialmedia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotBlank
    private String fullName;
    @Email
    @NotBlank
    private String email;
    private String bio;
}
