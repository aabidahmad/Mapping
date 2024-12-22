package com.mapping.controller;

import com.mapping.entity.Comment;
import com.mapping.entity.Post;
import com.mapping.repository.CommentRepository;
import com.mapping.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    private CommentRepository commentRepository;
    private PostRepository postRepository;
    public CommentController(CommentRepository commentRepository ,PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestParam long id ,@RequestBody Comment comment){
        System.out.println(id+" "+comment.getContent());
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);

    } 
    
}
