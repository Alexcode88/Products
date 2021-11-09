package com.codingdojo.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.app.models.Association;
import com.codingdojo.app.models.Category;
import com.codingdojo.app.models.Product;
import com.codingdojo.app.repositories.AssociationRepository;
import com.codingdojo.app.repositories.CategoryRepository;
import com.codingdojo.app.repositories.ProductRepository;

@Service
public class AppService {
	private final ProductRepository pRepo;
	private final CategoryRepository cRepo;
	private final AssociationRepository aRepo;
	public AppService(ProductRepository pRepo, CategoryRepository cRepo, AssociationRepository aRepo) {
		this.pRepo = pRepo;
		this.cRepo = cRepo;
		this.aRepo = aRepo;
	}
	public List<Product> findProducts() {
		return this.pRepo.findAll();
	}
	public Product getProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public List<Category> findCategories() {
		return this.cRepo.findAll();
	}
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	public Association createAssociation(Association ass) {
		return this.aRepo.save(ass);
	}
	public List<Category> findCategoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	public List<Product> findProductsNotInCategory(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}
}