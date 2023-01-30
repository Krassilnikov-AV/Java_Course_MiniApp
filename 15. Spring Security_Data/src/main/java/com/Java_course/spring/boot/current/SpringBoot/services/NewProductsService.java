package com.Java_course.spring.boot.current.SpringBoot.services;

import com.Java_course.spring.boot.current.SpringBoot.entities.*;
import com.Java_course.spring.boot.current.SpringBoot.repositories.NewProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class NewProductsService {

	// подключение к БД через репозиторий........
	private NewProductRepository newProductRepository;

	@Autowired
	public void setNewProductRepository(NewProductRepository newProductRepository) {
		this.newProductRepository = newProductRepository;
	}


	public Page<NewProduct> getNewProductWithPagingAndFiltering(Specification<NewProduct> specifications, Pageable pageable) {

		return newProductRepository.findAll(specifications, pageable);
	}

	public NewProduct getById(Long id) {
		return newProductRepository.findById(id).orElse(null);
	}

	public void deleteById(Long id) {
		newProductRepository.deleteById(id);
	}

	public void add(NewProduct product) {
		newProductRepository.save(product);
	}

	public void save(NewProduct product) {
		newProductRepository.save(product);
	}

	public void saveOrUpdate(NewProduct product) {
		newProductRepository.save(product);
	}
}