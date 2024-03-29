package com._securityProductData.services;


import com._securityProductData.entities.Product;
import com._securityProductData.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * - ProductsService -для работы с продуктами из БД,
 * выполняет полностью всю нашу работу (показать список всех наших товаров)
 */
@Service
public class ProductsService {
	// подключение к БД через репозиторий........
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// получение всех товаров, через репозиторий
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	/*
	* выполняет защиту на уровне сервиса, метод запустится при входе в ADMIN*/
	@Secured(value = ("ADMIN"))
	public List<Product> getAllProductsWitchFilter(String word) {
		List<Product> fullList = productRepository.findAll();
		if (word == null) {
			return fullList;
		}
		return fullList.stream().filter(p -> p.getTitle().contains(word)).collect(Collectors.toList());
	}

	public void add(Product product) {
		productRepository.save(product);
	}

	public Product getById(Long id) {
		return productRepository.findById(id);
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	public void saveOrUpdate(Product product) {
			productRepository.save(product);
	}
}
