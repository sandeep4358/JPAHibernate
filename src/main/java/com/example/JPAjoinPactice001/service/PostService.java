package com.example.JPAjoinPactice001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPAjoinPactice001.bean.socialmedia.Post;
import com.example.JPAjoinPactice001.bean.socialmedia.PostComment;
import com.example.JPAjoinPactice001.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	public Post getPostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createPost(Post post) {
		// Additional logic if needed

		//post.getComments().add(new PostComment(1l, "My first review"));
		//post.getComments().add(new PostComment(2l, "My second review"));
		//post.getComments().add(new PostComment(3l, "My third review"));
		return postRepository.save(post);
	}

	public PostComment addCommentToPost(Long postId, PostComment comment) {
		Post post = postRepository.findById(postId).orElse(null);

//		if (post != null) {
//			post.getComments().add(comment);
//			comment.set(post);
//			postRepository.save(post);
//		}

		return comment;
	}
	// Additional methods for creating, updating, and deleting posts if needed
}