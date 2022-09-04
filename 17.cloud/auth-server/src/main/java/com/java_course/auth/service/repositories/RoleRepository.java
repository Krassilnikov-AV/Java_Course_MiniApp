package com.java_course.auth.service.repositories;

import com.java_course.auth.service.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findOneByname(String name);
}