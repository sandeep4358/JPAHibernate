package com.example.JPAjoinPactice001.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPAjoinPactice001.bean.socialmedia.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    // Additional custom queries can be added here if needed
}