package com.Java_course.spring_security.current.repositories;


import com.Java_course.spring_security.current.entities.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * через интерфейс позволит более гибкое решение нежели наследование через класс*/
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>,
	JpaSpecificationExecutor<Product> {
}