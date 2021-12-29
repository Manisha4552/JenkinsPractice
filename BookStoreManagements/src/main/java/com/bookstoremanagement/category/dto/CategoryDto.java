package com.bookstoremanagement.category.dto;

public class CategoryDto {

	private int id;
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
	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", categoryName=" + categoryName + "]";
	}
	public CategoryDto(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
