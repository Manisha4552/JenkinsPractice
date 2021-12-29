package com.bookstoremanagement.category.mapper;

import com.bookstoremanagement.category.dto.CategoryDto;
import com.bookstoremanagement.category.entities.Category;

public class CategoryMapper {
	public static Category toCategory(CategoryDto categoryDto) 
	{
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setCategoryName(categoryDto.getCategoryName());
		return category;
		
		
	}
	
	public static CategoryDto toCategoryDto(Category category) 
	{
		CategoryDto categorydto = new CategoryDto();
		categorydto.setId(category.getId());
		categorydto.setCategoryName(category.getCategoryName());
		return categorydto;
	}
	
}
