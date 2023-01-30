package com.Java_course.spring.boot.current.SpringBoot.repositories;

/**
 * Класс NewProductRepositoryImpl
 *//*
public abstract class NewProductRepositoryImpl implements NewProductRepository {


	@Override
	public <S extends NewProduct> S save(NewProduct product) {
		return null;
	}

	// симуляция работы базы данных
	/*public void save(Product product) {
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

}*/