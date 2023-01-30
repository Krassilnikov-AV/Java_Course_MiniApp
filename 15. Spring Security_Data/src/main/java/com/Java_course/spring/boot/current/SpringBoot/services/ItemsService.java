package com.Java_course.spring.boot.current.SpringBoot.services;

import com.Java_course.spring.boot.current.SpringBoot.entities.Item;
import com.Java_course.spring.boot.current.SpringBoot.repositories.ItemRepositoryPading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {


//	private ItemRepository itemRepository;
//	@Autowired
//	public void setItemRepository(ItemRepository itemRepository) {
//		this.itemRepository = itemRepository;
//	}

//	public List<Item> getAllItems() {
//
//// получение в консоли данных по названию, вытащенных из БД при помощи Spring DAta
//		System.out.println(itemRepository.findByTitle("Tree"));
//		/*найти товар по стоимости от 30 до 70 (допустим)*/
//		System.out.println(itemRepository.findByCostBetween(30, 70));
////		System.out.println(itemRepository.findByTitleWith("House"));
////		/**смотреть данные, на 5-ой странице в количестве 20 шт*/
//		itemRepositoryPading.findAll(PageRequest.of(5, 20));
//		return itemRepository.findAll();
//	}

	/*
	 * работа со спецификациями
	 * */
	private ItemRepositoryPading itemRepositoryPading;

	@Autowired
	public void setItemRepositoryPading(ItemRepositoryPading itemRepositoryPading) {
		this.itemRepositoryPading = itemRepositoryPading;
	}

	/**
	 * Page - содержит информацию о страницах Item-ов, о номере текущей станицы и списо вобъектов на текущей странице
	 */
	public Page<Item> getItemsWithPagingAndFiltering(Specification<Item> specifications, Pageable pageable) {
		return itemRepositoryPading.findAll(specifications, pageable);
	}

	/*попытка получить определенные данные */
//	public Page<Item> getItemsWithPagingAndFiltering(Specification<Item>, Pageable pageable) {
//		List<ItemProjection> itemProjections = itemRepositoryPading.getProjections();
//		itemProjections.stream().forEach(->System.out.println(o.title()+ " "+ o.));
//		return itemRepositoryPading.findAll(specifications, pageable);
//	}


}