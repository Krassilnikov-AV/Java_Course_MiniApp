package com.spring.ItemsData.services;

import com.spring.ItemsData.entities.Item;
import com.spring.ItemsData.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
	private ItemRepository itemRepository;

	@Autowired
	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	//	public List<Item> getAllItems() {
//		// получение в консоли данных по названию, вытащенных из БД при помощи Spring DAta
//		System.out.println(itemRepository.findByTitle("Tree"));
//		System.out.println(itemRepository.findByCostBetween(30, 70));
//		System.out.println(itemRepository.findByTitleWith("House"));
//		/**смотреть данные, на 5-ой странице в количестве 20 шт*/
//		itemRepository.findAll(PageRequest.of(5, 20));
//
//		return itemRepository.findAll();
//	}
//	public List<Item> getAllItems() {
//// получение в консоли данных по названию, вытащенных из БД при помощи Spring DAta
//		System.out.println(itemRepository.findByTitle("Tree"));
//		System.out.println(itemRepository.findByCostBetween(30, 70));
//		System.out.println(itemRepository.findByTitleAndCostBetween("хлеб", 20, 40));
//		itemRepository.findAll(PageRequest.of(5,20));
//		return (List<Item>) itemRepository.findAll();
//	}
	/**
	 * Page - содержит информацию о страницах Item-ов,
	 * о номере текущей станицы и список вобъектов на текущей странице
	 */
	public Page<Item> getItemsWithPaginAndFiltering(Specification<Item> specifications, Pageable pageable) {

//		List<ItemProjection> itemProjections = itemRepository.getProjection();
//		itemProjections.stream().forEach(o-> System.out.println(o.title() + " " + o.cost()));

		return itemRepository.findAll(specifications, pageable);
	}
}