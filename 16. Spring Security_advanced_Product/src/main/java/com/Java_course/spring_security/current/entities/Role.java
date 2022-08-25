package com.Java_course.spring_security.current.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;

	@Column(name = "name")
	private String name;
//

	@Override
	public String toString() {
		return "Role{" +
			"id=" + id +
			", name='" + name + '\'' +
			'}';
	}
}