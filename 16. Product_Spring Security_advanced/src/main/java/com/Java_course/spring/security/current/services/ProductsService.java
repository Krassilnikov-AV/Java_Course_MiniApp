package com.Java_course.spring.security.current.services;

import com.Java_course.spring.security.current.entities.Product;
import com.Java_course.spring.security.current.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class ProductsService {

	// подключение к БД через репозиторий........
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Page<Product> getProductWithPagingAndFiltering(Specification<Product> specifications, Pageable pageable) {

		return productRepository.findAll(specifications, pageable);
	}

	public Product getById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}


	public void saveOrUpdate(Product product) {
		productRepository.save(product);
	}
}