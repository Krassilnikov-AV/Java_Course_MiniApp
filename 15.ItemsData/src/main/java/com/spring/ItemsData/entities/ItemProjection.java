package com.spring.ItemsData.entities;

/**
 * Класс ItemProjection для получения только title и cost.
 */
public interface ItemProjection {
	String title();
	int cost();
}