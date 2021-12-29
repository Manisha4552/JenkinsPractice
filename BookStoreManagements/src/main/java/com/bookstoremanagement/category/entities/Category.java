package com.bookstoremanagement.category.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
public class Category {
	@Id
	@Min(value = 101,message="Positive values are mandatory")
	private int id;
	@NotNull
	private String categoryName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + "]";
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
