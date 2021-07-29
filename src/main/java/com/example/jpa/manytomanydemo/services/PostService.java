package com.example.jpa.manytomanydemo.services;

import com.example.jpa.manytomanydemo.Model.Post;
import com.example.jpa.manytomanydemo.Model.Tag;
import com.example.jpa.manytomanydemo.exceptions.PostNotFoundException;
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


    public ResponseEntity<List<Post>> fetchAllPosts() {

        return ResponseEntity.ok(postRepository.findAll());
    }

    public ResponseEntity<Post> createNewPost(Post newPost) {
        postRepository.save(newPost);
        return ResponseEntity.ok(newPost);
    }

    public Post updatePost(Post updatedPost,Long id) {
      return  postRepository.findById(id)
                .map(post -> {
                    post.setContent(updatedPost.getContent());
                    post.setDescription(updatedPost.getDescription());
                    post.setTitle(updatedPost.getTitle());
                    return postRepository.save(post);
                })
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
