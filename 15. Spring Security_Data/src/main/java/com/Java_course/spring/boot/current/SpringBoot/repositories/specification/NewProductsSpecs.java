package com.Java_course.spring.boot.current.SpringBoot.repositories.specification;

import com.Java_course.spring.boot.current.SpringBoot.entities.NewProduct;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;


public class NewProductsSpecs {


	public static Specification<NewProduct> titleContains(String word) {
		return (Specification<NewProduct>) (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.like(root.get("title"), "%" + word + "%");
	}

	public static Specification<NewProduct> priceGreaterThanOrEq(BigDecimal value) {
		return (Specification<NewProduct>) (root, criteriaQuery, criteriaBuilder) ->{

		return 	criteriaBuilder.greaterThanOrEqualTo(root.get("price"), value);
		};
	}

	public static Specification<NewProduct> priceLesserThanOrEq(BigDecimal value) {
		return (Specification<NewProduct>) (root, criteriaQuery, criteriaBuilder) -> {
			return criteriaBuilder.lessThanOrEqualTo(root.get("price"), value);
		};
	}

//	public static Specification<NewProduct> addNewProductToBD(NewProduct product) {
//		return (Specification<NewProduct>) (root, criteriaQuery, criterianBuilder) ->
//			criterianBuilder.createQuery()
//	}
}