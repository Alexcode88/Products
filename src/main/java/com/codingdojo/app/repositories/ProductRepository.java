package com.codingdojo.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.app.models.Category;
import com.codingdojo.app.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}