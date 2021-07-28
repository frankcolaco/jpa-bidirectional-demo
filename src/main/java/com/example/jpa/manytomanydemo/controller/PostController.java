package com.example.jpa.manytomanydemo.controller;

import com.example.jpa.manytomanydemo.Model.Post;
import com.example.jpa.manytomanydemo.repositories.PostRepository;
import com.example.jpa.manytomanydemo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAllPosts(){
        return postService.fetchAllPosts();
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post newPost){
        return postService.createNewPost(newPost);
    }
}
