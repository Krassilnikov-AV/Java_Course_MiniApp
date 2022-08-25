package com.Java_course.spring.boot.current.SpringBoot.repositories.specification;

import com.Java_course.spring.boot.current.SpringBoot.entities.*;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

/**
 *
 */
public class NewProductsSpecs {


	public static Specification<NewProduct> titleContains(String word) {
		return (Specification<NewProduct>) (root, criteriaQuery, criterianBuilder) -> criterianBuilder.like(root.get("title"), "%"+word+"%");
	}

	public static Specification<NewProduct> priceGreaterThanOrEq(BigDecimal value) {
		return (Specification<NewProduct>) (root, criteriaQuery, criterianBuilder) -> {
			return criterianBuilder.greaterThanOrEqualTo(root.get("price"), value);
		};
	}

	public static Specification<NewProduct> priceLeeserThanOrEq(BigDecimal value) {
		return (Specification<NewProduct>) (root, criteriaQuery, criterianBuilder) -> {
			return criterianBuilder.lessThanOrEqualTo(root.get("price"), value);
		};
	}
}