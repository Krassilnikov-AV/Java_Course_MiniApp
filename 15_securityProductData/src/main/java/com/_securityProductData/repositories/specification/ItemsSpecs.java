package com._securityProductData.repositories.specification;


import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.domain.Specification;

public class ItemsSpecs {

	public static Specification<AbstractReadWriteAccess.Item> titleContains(String word) {
		return (Specification<Item>) (root, criteriaQuery, criterianBuilder) -> criterianBuilder.like(root.get("title"), "%"+word+"%");
	}

	public static Specification<Item> costGreaterThanOrEq(int value) {
		return (Specification<Item>) (root, criteriaQuery, criterianBuilder) -> {
			return criterianBuilder.greaterThanOrEqualTo(root.get("cost"), value);
		};
	}
}