package com.app.service;

import java.util.List;

import com.app.dto.CategoryDtoToUpdate;
import com.app.pojos.Category;


public interface CategoryService {

	
	List<Category> getAllCategories();
	Category findCategory(Long catId);
	String deleteCategory(Long catId);
	Category addCategory(Category newCategory);
	Category updateCategory(CategoryDtoToUpdate detachedCategory);
	
}
