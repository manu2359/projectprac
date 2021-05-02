package com.naturemart.root.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturemart.root.entity.Category;

import com.naturemart.root.repository.CategoryRepo;
import com.naturemart.root.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo pr;
	
	public List<Category> getAll(){
		
		List<Category> plist =  pr.findAll();
		
		return plist;
	}
	public Category getperbyId(Integer id) {
		
		System.out.println("service working");
		
		Category p =  pr.findById(id).get();
        
	   return p;
		
	}
	public Category save(Category p) {
		
		Category p2= pr.save(p);
		
		return p2;
		
	}
	public void remove(Category p) {
		
		pr.delete(p);
		
	}
    public void remove(Integer id) {
    	
    	pr.deleteById(id);
  		
    }

}
