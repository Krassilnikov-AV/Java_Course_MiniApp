package com._securityProductData.repositories;


import com._securityProductData.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * для работы с БД*/
@Component
public class ProductRepository {
	private List<Product> products;

	/**
	 * симуляция работы с БД
	 */
	@PostConstruct
	public void init() {
		products = new ArrayList<>();
		products.add(new Product(1L, "Bread", 40));
		products.add(new Product(2L, "Milk", 90));
		products.add(new Product(3L, "Cheese", 200));
	}

	public List<Product> findAll() {
		return products;
	}

	public Product findByTitle(String title) {
		return products.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
	}

	public Product findById(Long id) {
		return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
	}

	// симуляция работы базы данных
	public void save(Product product) {
		if (product.getId() == null) {
			Long newId = products.stream().mapToLong(Product::getId).max().getAsLong() + 1;
			product.setId(newId);
			products.add(product);
			return;
		}
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product p = iter.next();
			if (p.getId().equals(product.getId())) {
				p.setTitle(product.getTitle());
				p.setPrice(product.getPrice());
				return;
			}
		}
	}

//	public void deleteById(Long id) {
//		Iterator<Product> iter = products.iterator();
//		while (iter.hasNext()) {
//			Product product = iter.next();
//			if (product.getId().equals(id)) {
//				iter.remove();
//				return;
//			}
//		}
//	}
	// deleteById переписан на стрим
	public void deleteById(Long id) {
		products.remove(products.stream().filter(p->p.getId().equals(id)).findFirst().get());
	}
}