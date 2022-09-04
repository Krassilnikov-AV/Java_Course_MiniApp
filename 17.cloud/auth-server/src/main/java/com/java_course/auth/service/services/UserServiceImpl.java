package com.java_course.auth.service.services;

import com.java_course.auth.service.entities.User;
import com.java_course.auth.service.entities.Role;
import com.java_course.auth.service.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;


/**
 * В сервис инжектится репозиторий с пользователями.
 * Работа с ролями используется при регистрации.
 * UserDetails заставляет нас переопределить метод загрузки деталей пользователя (loadUserByUsername) через его
 * username, вытащив из БД основные данные о пользователе.
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}

	/**
	 * User user = userRepository.findOneByUsername(username)  - заходим в БД и пробуем вытащить пользователя
	 * еси успешно, то вытаскиваем детали о нём
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOneByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
			mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}