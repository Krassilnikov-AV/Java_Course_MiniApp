package com.spring.ItemsData.controllers;

//import package com._securityProductData.entities.Item;


import com.spring.ItemsData.entities.Item;
import com.spring.ItemsData.repositories.specification.ItemsSpecs;
import com.spring.ItemsData.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {
//	public String showItemsPage(Model model) {
//		return "items";
//	}
	private ItemsService itemsService;

	@Autowired
	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
//
//	@GetMapping
//	public String showItemsPage(Model model) {
////		model.addAttribute("items", itemsService.getAllItems());
//
////		Specification<Item> filter = Specification.where(null);
////		// стоимость бльше либо равно 30
////		filter = filter.and(ItemsSpecs.costGreaterThanOrEq(30));
////		List<Item> resultList = itemsService.getItemsWithPaginAndFiltering(filter, PageRequest.of(1, 2)).getContent();
////		model.addAttribute("items", resultList);
//		return "items";
//	}

//	private ItemsService itemsService;
//
//	@Autowired
//	public void setItemsService(ItemsService itemsService) {
//		this.itemsService = itemsService;
//	}
//
	@GetMapping
	public String showItemsPage(Model model) {

		Specification<Item> filter = Specification.where(null);
//		// стоимость бльше либо равно 30
		filter.and(ItemsSpecs.costGreaterThanOrEq(100));
		List<Item> resultList = itemsService.getItemsWithPaginAndFiltering(filter, PageRequest.of(1, 2)).getContent();
		model.addAttribute("items", resultList);
		return "items";
	}
}