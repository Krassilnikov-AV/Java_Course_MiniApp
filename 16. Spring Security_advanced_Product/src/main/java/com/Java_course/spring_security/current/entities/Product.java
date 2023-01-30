package com.Java_course.spring_security.current.entities;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private int price;
}