package com.example.JPAjoinPactice001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAjoinPactice001.bean.socialmedia.Post;
import com.example.JPAjoinPactice001.bean.socialmedia.PostComment;
import com.example.JPAjoinPactice001.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PostMapping("/{postId}/comments")
    public PostComment addCommentToPost(@PathVariable Long postId, @RequestBody PostComment comment) {
        return postService.addCommentToPost(postId, comment);
    }
    // Additional endpoints for creating, updating, and deleting posts if needed
}

