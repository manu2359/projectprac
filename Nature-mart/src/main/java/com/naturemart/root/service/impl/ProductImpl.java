package com.naturemart.root.service.impl;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.naturemart.root.entity.Product;
import com.naturemart.root.repository.ProductRepo;
import com.naturemart.root.service.ProductService;

@Service
public class ProductImpl implements ProductService{
	
	@Autowired
	private ProductRepo pr;
	
	
	private static final Logger log = LoggerFactory.getLogger(ProductImpl.class);

	
	public List<Product> getAll(){
		
		List<Product> plist =  pr.findAll();
		
		return plist;
	}
	
	 public List<Object[]> brandNamelike(String name){
		 
		 log.info("namelikebrand service is working");
		 
		 List<Object[]> plist =  pr.Namebrand(name+"%");
		
			/*
			 * if(plist.size()<1) { log.info(plist.get(0).toString()); }
			 */
		 
		 log.info("namelikebrand service is returning value");
		 
		 return plist;
	 }
	 
	 public List<Object[]> categoryNamelike(String name){
	    	
		 List<Object[]> plist =  pr.Namebrand(name);
		 
	    	return plist;
	    }
	 public List<Product> Namelike(String name){
		 
	 List<Product> plist=pr.findByNamelike(name);
		 
		 return plist;
		 
	 }
	public Product getperbyId(Integer id) {
		
		System.out.println("service working");
		
        Product p =  pr.findById(id).get();
	
        System.out.println(p.getName());
        
	   return p;
		
	}
	public Product save(Product p) {
		
       Product p2= pr.save(p);
		
		return p2;
		
	}
	public void remove(Product p) {
		
		pr.delete(p);
		
	}
    public void remove(Integer id) {
    	
    	pr.deleteById(id);
  		
    }

}
