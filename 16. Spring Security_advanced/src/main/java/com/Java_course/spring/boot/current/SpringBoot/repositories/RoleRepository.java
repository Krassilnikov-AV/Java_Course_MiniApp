package com.Java_course.spring.boot.current.SpringBoot.repositories;


import com.Java_course.spring.boot.current.SpringBoot.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findOneByname(String name);
}