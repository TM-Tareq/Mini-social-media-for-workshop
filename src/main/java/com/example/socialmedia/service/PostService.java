package com.example.socialmedia.service;

import com.example.socialmedia.dto.PostRequestDTO;
import com.example.socialmedia.dto.PostResponseDTO;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.exception.CustomException;
import com.example.socialmedia.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDTO createPost(PostRequestDTO request) {
        Post post = new Post();

        post.setAuthorName(request.getAuthorName());
        post.setContent(request.getContent());
        post.setCreatedAt(LocalDateTime.now());

        Post savedPost = postRepository.save(post);

        PostResponseDTO response = new PostResponseDTO();

        response.setId(savedPost.getId());
        response.setAuthorName(savedPost.getAuthorName());
        response.setContent(savedPost.getContent());
        response.setCreatedAt(savedPost.getCreatedAt());

        return response;
    }

    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findByActiveTrue().stream().map(post -> {
            PostResponseDTO response = new PostResponseDTO();
            response.setId(post.getId());
            response.setAuthorName(post.getAuthorName());
            response.setContent(post.getContent());
            response.setCreatedAt(post.getCreatedAt());

            return response;
        }).toList();
    }

    public String deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new CustomException("Post not found"));

        post.setActive(false);

        postRepository.save(post);

        return "Post deleted successfully";
    }
}
