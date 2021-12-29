package com.bookstoremanagement.category.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoremanagement.category.dto.CategoryDto;
import com.bookstoremanagement.category.entities.Category;
import com.bookstoremanagement.category.responses.ResponseInfo;
import com.bookstoremanagement.category.services.ICategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
//@Api("Controller for different endpoints")
public class CategoryController {
	
	@Autowired
	ICategoryService cs;

//	@ApiOperation("Fetch all the records")
	@GetMapping("/category")
	public List<Category> viewAllCategory(){
		return cs.viewAllCategories();
	}
	
//	@PostMapping("/category/byName/{name}")
//	public Category saveName(@PathVariable("name") String categoryName) {
//		return cs.saveName(categoryName);
//		
//	}
	
	@PutMapping("/category")
	public Category updateMovies(@RequestBody CategoryDto c) {
		return cs.editCategory(c);
		
	}
	

	
	@DeleteMapping("/category/{cid}")
	public String deleteMovies(@PathVariable("cid") int id) {
		cs.removeCategory(id);
		return "DELETED";
	}
	
	@PostMapping("/category")
	public Category addCategory(@Valid @RequestBody CategoryDto cat) {
		return cs.addCategory(cat);
		
	}
}
