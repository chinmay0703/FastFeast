package com.app.dto;

import java.util.Objects;




/*
 * Product Entity : id, name,price,desc,inStock +
private Category productCategory;

 */

public class CategoryDto {
	
	private String categoryName;
	private String description;
	
	public CategoryDto() {
		super();
	}
	public CategoryDto(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CategoryDto [categoryName=" + categoryName + ", description=" + description + "]";
	}
	
}
