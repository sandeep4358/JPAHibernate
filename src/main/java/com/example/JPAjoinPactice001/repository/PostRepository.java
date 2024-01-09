package com.example.JPAjoinPactice001.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JPAjoinPactice001.bean.socialmedia.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // Additional query methods if needed
}