package com.Java_course.spring_security.current.repositories;

import com.Java_course.spring_security.current.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
User findOneByUsername(String userName);

}