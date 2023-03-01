package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CategoryDtoToUpdate;
import com.app.pojos.Category;
import com.app.pojos.Pizza;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository catRepo;
	
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return catRepo.findAll();
	}

	@Override
	public Category findCategory(Long catId) {
		// TODO Auto-generated method stub
		return catRepo.findById(catId)
				.orElseThrow(()-> new ResourceNotFoundException("invalid catId"));
	}

	@Override
	public String deleteCategory(Long catId) {
		// TODO Auto-generated method stub
		String msg="unable to delete category !!";
		if(catRepo.existsById(catId))
		{
			msg="category deleted successfully !!";
			catRepo.deleteById(catId);
		}
		return msg;
	}

	@Override
	public Category addCategory(Category newCategory) {
		// TODO Auto-generated method stub
		return catRepo.save(newCategory);
	}

	
	@Override
	public Category updateCategory(CategoryDtoToUpdate detachedCategory) {
		// TODO Auto-generated method stub
		
		Category persistentCategory=catRepo.findById(detachedCategory.getId())
				.orElseThrow(() -> new ResourceNotFoundException("invalid category id !!!!!"));

		persistentCategory.setCategoryName(detachedCategory.getCategoryName());
		persistentCategory.setDescription(detachedCategory.getDescription());
			
			return persistentCategory;
	
		
		
	}

}
