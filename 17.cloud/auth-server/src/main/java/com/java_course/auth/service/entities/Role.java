package com.java_course.auth.service.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "id")
	Long id;

	@Column(name = "name")
	private String name;

	public Role(String name) {
		this.name=name;
	}
}