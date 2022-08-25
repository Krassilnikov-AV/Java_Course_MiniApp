package com.Java_course.spring.security.current.services;

import com.Java_course.spring.security.current.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
	User findByUsername(String username);
}