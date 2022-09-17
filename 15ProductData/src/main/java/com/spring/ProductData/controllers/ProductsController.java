package com.spring.ProductData.controllers;

import com.spring.ProductData.entities.Product;
import com.spring.ProductData.repositories.specification.ProductsSpecs;
import com.spring.ProductData.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 1. Перенесите всю работу с товарами на репозитории;
 * 2. Добавьте  пагинацию,  с  выводом  на  страницу  по  5  товаров;
 */
@Controller
@RequestMapping("/products")
public class ProductsController {

	private ProductsService productsService;

	@Autowired
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
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
		Specification<Product> specification = Specification.where(null);
		if (word != null) {
			specification = specification.and(ProductsSpecs.titleContains(word));
		}
		if (minPrice != null) {
			specification = specification.and(ProductsSpecs.priceGreaterThanOrEq(minPrice));
		}
		if (maxPrice != null) {
			specification = specification.and(ProductsSpecs.priceLesserThanOrEq(maxPrice));
		}
		Product product = new Product();
		model.addAttribute("products", productsService.getProductWithPagingAndFiltering(specification,
			PageRequest.of(page - 1, 5)).getContent());
		model.addAttribute("product", product);
		model.addAttribute("word", word);
		model.addAttribute("minPrice", minPrice);
		model.addAttribute("maxPrice", maxPrice);
		return "products";
	}

	@GetMapping("/add")
	public String showAddProductFrom(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product-edit";
	}

	@GetMapping("/edit/{id}")
	public String showEditProductFrom(Model model, @PathVariable(value = "id") Long id) {
		Product product = productsService.getById(id);
		model.addAttribute("product", product);
		return "product-edit";
	}

	@PostMapping("/edit")
	public String addProduct(@ModelAttribute(value = "product") Product product) {
		productsService.saveOrUpdate(product);
		return "redirect:/products";
	}

	@GetMapping("/show/{id}")
	public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
		Product product = productsService.getById(id);
		model.addAttribute("product", product);
		return "product-page";
	}

	/**
	 * - redirect: - посылаете запрос на страницу /products
	 */
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable(value = "id") Long id) {
		productsService.deleteById(id);
		return "redirect:/products";
	}
}
