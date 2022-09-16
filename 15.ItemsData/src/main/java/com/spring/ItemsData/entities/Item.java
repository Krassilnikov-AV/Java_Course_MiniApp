package com.spring.ItemsData.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "cost")
	private int cost;

	@Override
	public String toString() {
		return String.format("Item [id= %d title = %s cost= %d]", id, title, cost);
	}
}