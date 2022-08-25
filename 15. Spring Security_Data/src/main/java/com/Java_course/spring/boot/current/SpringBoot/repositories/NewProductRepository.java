package com.Java_course.spring.boot.current.SpringBoot.repositories;


import com.Java_course.spring.boot.current.SpringBoot.entities.*;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
/**
 * через интерфейс позволит более гибкое решение нежели наследование через класс*/
@Repository
public interface NewProductRepository extends PagingAndSortingRepository<NewProduct, Long>,
	JpaSpecificationExecutor<NewProduct> {
}