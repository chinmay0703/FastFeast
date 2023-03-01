package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CategoryDto;
import com.app.dto.CategoryDtoToUpdate;
import com.app.pojos.Category;
import com.app.service.CategoryService;


@RestController
//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService catService;

	@Autowired(required = false)
	private ModelMapper mapper;

	@GetMapping("/getAllCategoris")
	public List<Category> getAllCategories() {
		System.out.println("in get all categories");
		return catService.getAllCategories();
	}

	@DeleteMapping("/deleteCategory/{catId}")
	public String deleteCategory(@PathVariable Long catId) {
		return catService.deleteCategory(catId);
	}

	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody CategoryDto catDto) {
		Category newCategory = mapper.map(catDto, Category.class);

		return catService.addCategory(newCategory);
	}

	@PutMapping("/updateCategory")
	public Category updateCategory(@RequestBody CategoryDtoToUpdate detachedCategory) {

		return catService.updateCategory(detachedCategory);
	}

}
