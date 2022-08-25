package com.Java_course.spring.boot.current.SpringBoot.entities;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class NewProduct {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column
	private String title;

	@Column
	private int price;
}