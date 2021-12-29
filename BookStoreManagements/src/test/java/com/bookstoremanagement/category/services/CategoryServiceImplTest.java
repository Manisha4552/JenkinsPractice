package com.bookstoremanagement.category.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

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
import com.bookstoremanagement.category.exceptions.IdNotFoundException;
import com.bookstoremanagement.category.mapper.CategoryMapper;
import com.bookstoremanagement.category.repository.CategoryRepo;
import com.bookstoremanagement.category.services.CategoryServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
	
	@InjectMocks
	CategoryServiceImpl csi;
	
	@Mock
	 Category category; 
	@Mock
	 Category category1;
	@Mock
	 CategoryRepo cr;
	

	@BeforeEach
	 public void startup() {
		 
		 MockitoAnnotations.initMocks(this);
		 
		 category.setId(101);
		 category.setCategoryName("Drama");
		 
		 category1.setId(102);
		 category1.setCategoryName("Drama1");
		 
		 
	 }
	@Test
    void testCatById() {
        when(cr.findById(101)).thenReturn(Optional.of(category));
        assertEquals(category,csi.getCategoryById(101));
        Mockito.verify(cr,times(1)).findById(101);
    }
	
	@Test
    void testCatByIdThatIsNotFound() {
        when(cr.findById(101)).thenReturn(Optional.ofNullable(null));
        assertThrows(IdNotFoundException.class, ()->csi.getCategoryById(101));
	}
	
	
	@Test public void testaddCustomer() { 
	Mockito.when(cr.save(any(Category.class))).thenReturn(category);
	CategoryDto categorydto1=CategoryMapper.toCategoryDto(category);
	Category categorydto2=csi.addCategory(categorydto1);
	assertEquals(categorydto1.getId(),categorydto2.getId());
	Mockito.verify(cr,times(1)).save(any(Category.class));
	}


	
	@Test
	public void testViewAllCategory() {
		Mockito.when(cr.findAll()).thenReturn(Arrays.asList(category));
		assertEquals(Arrays.asList(category),csi.viewAllCategories());
		Mockito.verify(cr).findAll();
	}
	
	@Test
	 public void removeCategoryTest() {
//		 category = new Category(1,"Drama");
		when(cr.findById(1)).thenReturn(Optional.of(category));
		assertEquals("REMOVE",csi.removeCategory(1));
		 Mockito.verify(cr).deleteById(1);
	 }
	
}
