package com.example.jpa.manytomanydemo.services;

import com.example.jpa.manytomanydemo.Model.Post;
import com.example.jpa.manytomanydemo.Model.Tag;
import com.example.jpa.manytomanydemo.repositories.PostRepository;
import com.example.jpa.manytomanydemo.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    TagRepository tagRepository;


    public ResponseEntity<List<Post>> fetchAllPosts() {

        return ResponseEntity.ok(postRepository.findAll());
    }

    public ResponseEntity<Post> createNewPost(Post newPost) {
        postRepository.save(newPost);
        return ResponseEntity.ok(newPost);
    }
}
