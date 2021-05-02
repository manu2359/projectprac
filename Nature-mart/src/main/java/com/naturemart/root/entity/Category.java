package com.naturemart.root.entity;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String categoryname;
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	
	
	
	
	

}
