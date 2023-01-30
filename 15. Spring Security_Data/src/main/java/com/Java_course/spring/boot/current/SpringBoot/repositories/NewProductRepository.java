package com.Java_course.spring.boot.current.SpringBoot.repositories;

import com.Java_course.spring.boot.current.SpringBoot.entities.NewProduct;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;
/**
 * через интерфейс позволит более гибкое решение нежели наследование через класс*/
@Repository
public interface NewProductRepository extends CrudRepository<NewProduct, Long>, PagingAndSortingRepository<NewProduct, Long>,
	JpaSpecificationExecutor<NewProduct> {

	//	TO DO запрос на внесение продукта в БД
//	@Query(value = "INSERT e INTO NewProduct e (title, price) VALUES ()")
//	public default void addNewProduct() {
//
//	}
//
//	@Query("INSERT e FROM NewProduct e WHERE e.age = :age")
//	public List findByAge(@Param("age") int age);
//	INSERT INTO NewProduct (title, price) VALUES ('Bread', 40),
//		('Milk', 80);
//}
//
//@Repository
//public interface EmployeeRepository extends CrudRepository<Employee, Long>{
//	List findByLastName(String lastName);
//
//	@Query("SELECT e FROM Employee e WHERE e.age = :age")
//	public List findByAge(@Param("age") int age);
}