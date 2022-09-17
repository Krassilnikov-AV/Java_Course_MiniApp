package com.spring.ProductData.repositories;


import com.spring.ProductData.entities.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * для работы с БД*/
@Component
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {

}