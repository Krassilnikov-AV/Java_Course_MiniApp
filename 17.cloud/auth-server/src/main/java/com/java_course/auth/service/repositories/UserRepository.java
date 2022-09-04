package com.java_course.auth.service.repositories;

import com.java_course.auth.service.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
User findOneByUsername(String userName);

}