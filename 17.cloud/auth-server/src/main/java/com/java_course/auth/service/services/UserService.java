package com.java_course.auth.service.services;

import com.java_course.auth.service.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
	User findByUsername(String username);
}