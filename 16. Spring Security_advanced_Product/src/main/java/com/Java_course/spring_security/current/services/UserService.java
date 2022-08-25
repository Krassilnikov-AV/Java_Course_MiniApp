package com.Java_course.spring_security.current.services;

import com.Java_course.spring_security.current.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
	User findByUsername(String username);
}