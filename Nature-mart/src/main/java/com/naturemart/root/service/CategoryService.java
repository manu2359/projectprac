package com.naturemart.root.service;

import java.util.List;



import com.naturemart.root.entity.Category;



public interface CategoryService {
	
	public List<Category> getAll();
	public Category getperbyId(Integer id);
	public Category save(Category p);
	public void remove(Category p);
    public void remove(Integer id);

}
