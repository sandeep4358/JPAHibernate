package com.example.JPAjoinPactice001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPAjoinPactice001.bean.socialmedia.UserAccount;
import com.example.JPAjoinPactice001.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    public UserAccount getUserById(Long userId) {
    	log.info("UserDetails with id : {} " +userId);    	

        return userRepository.findById(userId).orElse(null);
    }

    public UserAccount createUser(UserAccount user) {
    	log.info("UserDetails : {} " +user);    	
    	//this is mandatory in case of the bidirectional relation ship, if not do this then null will be saved in the foreign key of  inverse entity.
    	user.getPosts().forEach(p->p.setUserAccount(user));  // need to fetch and save the user in the each element of the list
    	
    	//for the second layer we need to do it again.
    	user.getPosts().forEach(p->{
    		p.getComments().forEach(c->c.setPost(p));
    	});
    	
        return userRepository.save(user);
    }

    public UserAccount updateUser(Long userId, UserAccount updatedUser) {
        UserAccount existingUser = userRepository.findById(userId).orElse(null);

//        if (existingUser != null) {
//            existingUser.setFirstName(updatedUser.getFirstName());
//            existingUser.setLastName(updatedUser.getLastName());
//            existingUser.setSubscribeOn(updatedUser.getSubscribedOn());
//
//            return userRepository.save(existingUser);
//        }

        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}