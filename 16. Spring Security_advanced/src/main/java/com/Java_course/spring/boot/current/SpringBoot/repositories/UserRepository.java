package com.Java_course.spring.boot.current.SpringBoot.repositories;

import com.Java_course.spring.boot.current.SpringBoot.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
User findOneByUsername(String userName);

}