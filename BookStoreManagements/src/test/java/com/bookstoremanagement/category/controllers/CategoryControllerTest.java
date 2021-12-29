package com.bookstoremanagement.category.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookstoremanagement.category.controllers.CategoryController;
import com.bookstoremanagement.category.dto.CategoryDto;
import com.bookstoremanagement.category.entities.Category;
import com.bookstoremanagement.category.services.ICategoryService;

//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {
	
	
	
	@InjectMocks
	CategoryController categorycontroller;
	
	@Mock
	Category category;
	@Mock
	ICategoryService cs;
	
	@Mock
	CategoryDto categoryDto;
	@Mock
	CategoryDto categoryDto1;
	
	 @BeforeEach
	 public void startup() {
		 
		 MockitoAnnotations.initMocks(this);
		 
		 categoryDto.setId(101);
		 categoryDto.setCategoryName("Drama");
		 
		 categoryDto1.setId(102);
		 categoryDto1.setCategoryName("Drama1");
		 
		 when(cs.editCategory(categoryDto)).thenReturn(category);
		 when(cs.removeCategory(categoryDto.getId())).thenReturn("DELETED");
	 }
	
	@Test
	public void testaddCategory() {
		Mockito.when(cs.addCategory(categoryDto)).thenReturn(category);  
		assertEquals(category,categorycontroller.addCategory(categoryDto));
		Mockito.verify(cs).addCategory(categoryDto);
	}

	@Test
	public void testViewAllCategory() {
		Mockito.when(cs.viewAllCategories()).thenReturn(Arrays.asList(category));
		assertEquals(Arrays.asList(category),categorycontroller.viewAllCategory());
		Mockito.verify(cs).viewAllCategories();
	}

	@Test
    public void editCategoryTest() {
		categoryDto1 = new CategoryDto(2,"Comedy");
		when(cs.editCategory(categoryDto1)).thenReturn(category);
        Category categoryUpdate = cs.editCategory(categoryDto1);
        assertEquals(category, categoryUpdate);
    }
	
	 @Test
	 public void removeCategoryTest() {
		 category = new Category(1,"Drama");
		 when(cs.removeCategory(category.getId())).thenReturn("DELETED");
		 String status = cs.removeCategory(1);
		 assertEquals("DELETED", status);
	 }
	
}
