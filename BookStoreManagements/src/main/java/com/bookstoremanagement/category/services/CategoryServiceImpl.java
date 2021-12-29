package com.bookstoremanagement.category.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoremanagement.category.dto.CategoryDto;
import com.bookstoremanagement.category.entities.Category;
import com.bookstoremanagement.category.exceptions.IdNotFoundException;
import com.bookstoremanagement.category.mapper.CategoryMapper;
import com.bookstoremanagement.category.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	CategoryRepo cr;

	@Override
	public List<Category> viewAllCategories() {
		return cr.findAll();
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public Category saveName(String categoryName) {
//		return cr.saveName(categoryName);
//		
//	}

	@Override
	public Category editCategory(CategoryDto cat) {
		// TODO Auto-generated method stub
		Category categoryobj1 = CategoryMapper.toCategory(cat);
		return cr.save(categoryobj1);
	}

	@Override
	public String removeCategory(int id) {
		// TODO Auto-generated method stub
		Optional<Category> cat = cr.findById(id);
		if(cat.isPresent()) {
			 cr.deleteById(id);
			 return "REMOVE";
		}
		else {
			throw new IdNotFoundException("Id not found");
		}

	}

	@Override
	public Category addCategory(CategoryDto categorydto) {
		// TODO Auto-generated method stub
		Category categoryobj = CategoryMapper.toCategory(categorydto);
		return cr.save(categoryobj);
	}
	

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		Optional<Category> cat = cr.findById(id);
		if(cat.isPresent()) {
			return cat.get();
		}
		throw new IdNotFoundException("Id not found");
	}

}
