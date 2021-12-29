package com.bookstoremanagement.category.services;

import java.util.List;

import com.bookstoremanagement.category.dto.CategoryDto;
import com.bookstoremanagement.category.entities.Category;

public interface ICategoryService {

	public List<Category> viewAllCategories();
	public Category editCategory(CategoryDto cat);
	public String removeCategory(int id);
	
//	Category saveName(String categoryName);
	public Category getCategoryById(int id);
	Category addCategory(CategoryDto cat);
	
	
}
