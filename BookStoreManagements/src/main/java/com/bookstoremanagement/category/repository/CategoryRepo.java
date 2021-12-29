package com.bookstoremanagement.category.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstoremanagement.category.dto.CategoryDto;
import com.bookstoremanagement.category.entities.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
	
	
	public Category getCategoryById(int id);

	
}
