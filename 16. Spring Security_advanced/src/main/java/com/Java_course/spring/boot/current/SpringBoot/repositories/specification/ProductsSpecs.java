package com.Java_course.spring.boot.current.SpringBoot.repositories.specification;

import com.Java_course.spring.boot.current.SpringBoot.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

/**
 *
 */
public class ProductsSpecs {


	public static Specification<Product> titleContains(String word) {
		return (Specification<Product>) (root, criteriaQuery, criterianBuilder) -> criterianBuilder.like(root.get("title"), "%"+word+"%");
	}

	public static Specification<Product> priceGreaterThanOrEq(BigDecimal value) {
		return (Specification<Product>) (root, criteriaQuery, criterianBuilder) -> {
			return criterianBuilder.greaterThanOrEqualTo(root.get("price"), value);
		};
	}

	public static Specification<Product> priceLesserThanOrEq(BigDecimal value) {
		return (Specification<Product>) (root, criteriaQuery, criterianBuilder) -> {
			return criterianBuilder.lessThanOrEqualTo(root.get("price"), value);
		};
	}
}