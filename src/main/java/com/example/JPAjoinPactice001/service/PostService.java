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
		//below is very important part of the bidirectional communication.
		post.getComments().forEach(
				p -> p.setPost(post)
				);		
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