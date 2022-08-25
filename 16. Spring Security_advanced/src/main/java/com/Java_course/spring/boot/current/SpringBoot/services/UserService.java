package com.Java_course.spring.boot.current.SpringBoot.services;

import com.Java_course.spring.boot.current.SpringBoot.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService {
	User findByUsername(String username);
}