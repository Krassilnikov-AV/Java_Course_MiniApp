package com.Java_course.spring.security.current.entities;


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

	@Column
	private String title;

	@Column
	private int price;
}