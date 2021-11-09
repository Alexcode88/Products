package com.codingdojo.app.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.app.models.Category;
import com.codingdojo.app.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
}