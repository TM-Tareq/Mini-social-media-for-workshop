package com.example.socialmedia.service;

import com.example.socialmedia.dto.UserRequestDTO;
import com.example.socialmedia.dto.UserResponseDTO;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.exception.CustomException;
import com.example.socialmedia.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO Request) {
        User user = new User();

        user.setFullName(Request.getFullName());
        user.setEmail(Request.getEmail());
        user.setBio(Request.getBio());

        User savedUser = userRepository.save(user);
        UserResponseDTO response = new UserResponseDTO();

        response.setId(savedUser.getId());
        response.setFullName(savedUser.getFullName());
        response.setEmail(savedUser.getEmail());
        response.setBio(savedUser.getBio());

        return response;
    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new CustomException("User not found!"));

        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setBio(user.getBio());

        return response;
    }

    public UserResponseDTO updateUserBio(Long id, String bio) {
        User user = userRepository.findById(id).orElseThrow(()-> new CustomException("User not found!"));
        user.setBio(bio);

        User updatedUser = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(updatedUser.getId());
        response.setFullName(updatedUser.getFullName());
        response.setEmail(updatedUser.getEmail());
        response.setBio(updatedUser.getBio());

        return response;
    }

}
