package com.mapping.controller;

import com.mapping.entity.Post;
import com.mapping.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        if (post.getTitle() == null || post.getTitle().isEmpty()) {
            return new ResponseEntity<>("Title is required", HttpStatus.BAD_REQUEST);
        }
        if (post.getDescription() == null || post.getDescription().isEmpty()) {
            return new ResponseEntity<>("Description is required", HttpStatus.BAD_REQUEST);
        }
        Post savedPost = postRepository.save(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }
    @PostMapping("/try")
    public String createPost1(@RequestBody Post post) {
        return "working ";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
         postRepository.deleteById(id);
        return "postDeleted";
    }
}
