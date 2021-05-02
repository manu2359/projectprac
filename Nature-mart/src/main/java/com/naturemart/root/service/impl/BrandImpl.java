package com.naturemart.root.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturemart.root.entity.Brand;
import com.naturemart.root.repository.BrandRepo;
import com.naturemart.root.service.BrandService;


@Service
public class BrandImpl implements BrandService{
	
	@Autowired
	private BrandRepo pr;
	
	public List<Brand> getAll(){
		
		List<Brand> plist =  pr.findAll();
		
		return plist;
	}
	public Brand getperbyId(Integer id) {
		
		System.out.println("service working");
		
		Brand p =  pr.findById(id).get();
        
	   return p;
		
	}
	public Brand save(Brand p) {
		
		Brand p2= pr.save(p);
		
		return p2;
		
	}
	public void remove(Brand p) {
		
		pr.delete(p);
		
	}
    public void remove(Integer id) {
    	
    	pr.deleteById(id);
  		
    }


}
