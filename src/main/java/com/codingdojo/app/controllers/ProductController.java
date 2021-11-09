package com.codingdojo.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.app.models.Association;
import com.codingdojo.app.models.Category;
import com.codingdojo.app.models.Product;
import com.codingdojo.app.services.AppService;

@Controller
public class ProductController {
	private AppService appService;
	public ProductController(AppService service) {
		this.appService = service;
	}
	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("products", appService.findProducts());
		return "products/index.jsp";
	}
	@GetMapping("/{id}")
	public String Show(@ModelAttribute("association") Association association, 
		@PathVariable("id") Long id, Model model) {
		Product thisOne = appService.getProduct(id);
		List<Category> others = appService.findCategoriesNotInProduct(thisOne);
		model.addAttribute("product", thisOne);
		model.addAttribute("notInCategories", others);
		return "products/show.jsp";
	}
}