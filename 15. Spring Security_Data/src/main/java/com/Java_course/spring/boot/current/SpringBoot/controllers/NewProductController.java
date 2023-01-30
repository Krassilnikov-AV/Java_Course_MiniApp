package com.Java_course.spring.boot.current.SpringBoot.controllers;

import com.Java_course.spring.boot.current.SpringBoot.entities.NewProduct;
import com.Java_course.spring.boot.current.SpringBoot.repositories.specification.NewProductsSpecs;
import com.Java_course.spring.boot.current.SpringBoot.services.NewProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/*
/**
 * 1. Перенесите всю работу с товарами на репозитории;
 * 2. Добавьте  пагинацию,  с  выводом  на  страницу  по  5  товаров;
 */
@Controller
@RequestMapping("/products")
public class NewProductController {

	private NewProductsService newProductsService;

	@Autowired
	public void setProductsService(NewProductsService newProductsService) {
		this.newProductsService = newProductsService;
	}

	/**
	 * пример: /products?word=Hello
	 * поиск товара,  котором есть слово "Hello"
	 * * - required = false - не обязатеьный параметр
	 */
	@GetMapping
	public String showProductsList(Model model,
								   @RequestParam(value = "page", required = false) Integer page,
								   @RequestParam(value = "word", required = false) String word,
								   @RequestParam(value = "minPrice", required = false) BigDecimal minPrice,
								   @RequestParam(value = "maxPrice", required = false) BigDecimal maxPrice
	) {
		if (page == null) {
			page = 1;
		}
		Specification<NewProduct> specification = Specification.where(null);
		if (word != null) {
			specification = specification.and(NewProductsSpecs.titleContains(word));
		}
		if (minPrice != null) {
			specification = specification.and(NewProductsSpecs.priceGreaterThanOrEq(minPrice));
		}
		if (maxPrice != null) {
			specification = specification.and(NewProductsSpecs.priceLesserThanOrEq(maxPrice));
		}
		NewProduct product = new NewProduct();
		model.addAttribute("products", newProductsService.getNewProductWithPagingAndFiltering(specification,
			PageRequest.of(page-1, 10)).getContent());
		model.addAttribute("product", product);
		model.addAttribute("word", word);
		model.addAttribute("minPrice", minPrice);
		model.addAttribute("maxPrice", maxPrice);
		return "products";
	}

	@GetMapping("/add")
	public String showAddProductFrom(Model model) {
		model.addAttribute("product", new NewProduct());
		return "product-edit";
	}

	@GetMapping("/edit/{id}")
	public String showEditProductFrom(Model model, @PathVariable(value = "id") Long id) {
		NewProduct product = newProductsService.getById(id);
		model.addAttribute("product", product);
		return "product-edit";
	}

	@PostMapping("/edit")
	public String addProduct(@ModelAttribute(value = "product") NewProduct product) {
		newProductsService.saveOrUpdate(product);
		return "redirect:/products";
	}

	@GetMapping("/show/{id}")
	public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
		NewProduct product = newProductsService.getById(id);
		model.addAttribute("product", product);
		return "product-page";
	}

	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") NewProduct product) {
		newProductsService.save(product);
		return "redirect:/products";
	}

	/**
	 * - redirect: - посылаете запрос на страницу /products
	 */
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable(value = "id") Long id) {
		newProductsService.deleteById(id);
		return "redirect:/products";
	}
}