package com.example.jpa.manytomanydemo.controller;

import com.example.jpa.manytomanydemo.Model.Post;
import com.example.jpa.manytomanydemo.repositories.PostRepository;
import com.example.jpa.manytomanydemo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePosts(@RequestBody Post updatedPost,@PathVariable Long id){
        return ResponseEntity.ok(postService.updatePost(updatedPost,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePosts(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.ok("deleted successfully");
    }
}
