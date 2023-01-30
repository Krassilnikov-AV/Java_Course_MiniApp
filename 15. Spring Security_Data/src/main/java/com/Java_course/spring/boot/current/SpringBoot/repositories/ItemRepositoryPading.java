package com.Java_course.spring.boot.current.SpringBoot.repositories;

import com.Java_course.spring.boot.current.SpringBoot.entities.Item;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryPading extends JpaRepository<Item, Long>, PagingAndSortingRepository<Item, Long>,
	JpaSpecificationExecutor<Item> {
	/*метод для поиска определенных полей сущности в БД*/
//	List<ItemProjection> getProjections();
}