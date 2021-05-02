package com.naturemart.root.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naturemart.root.entity.Brand;
import com.naturemart.root.entity.Category;
import com.naturemart.root.entity.Product;
import com.naturemart.root.repository.ProductRepo;
import com.naturemart.root.service.ProductService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("product")
public class ProductController {
	
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	
	@Autowired
	private ProductService ps;
	
	@PostMapping("/savepro")
	public ResponseEntity<Product> saveprodu(@RequestBody Product p) {
		
		Product p2=ps.save(p);
		
		return new ResponseEntity(p2 , HttpStatus.CREATED);
	}
	
	@GetMapping("/namelike")
	public ResponseEntity<List<Product>> namelike(String name){
		
		
        List<Product> plist = ps.Namelike(name);
        
        for (Product product : plist) {
			
        	log.info(product.getName());
		}
	
	return new ResponseEntity(plist, HttpStatus.OK);
  }
	
	@GetMapping("/brandnamelike")
	public ResponseEntity<List<Object[]>> namelikeforbrand(String name){
		
		log.info("namelikebrand working");
		
		
        List<Object[]> plist = ps.brandNamelike(name);
        
          for (Object[] o : plist) {
			
        	for (int i = 0; i < o.length; i++) {
				
        		//log.info((String) o[i]);
        		System.out.println(o[i]);
        		
			}
		}
	
	return new ResponseEntity(plist, HttpStatus.OK);
  }
	
	@GetMapping("/categorynamelike")
	public ResponseEntity<List<Object[]>> namelikeforcategory(String name){
		
		
        List<Object[]> plist = ps.categoryNamelike(name);
	
	return new ResponseEntity(plist, HttpStatus.OK);
  }
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deletepro(@PathVariable Integer id){
		
		   ps.remove(id);
		
		return new ResponseEntity(id , HttpStatus.OK);
	}
	
	@GetMapping("/getone/{id}")
	public ResponseEntity<Product> getproduct(@PathVariable Integer id){
		  
		System.out.println("controller working");
		
              Product p =  ps.getperbyId(id);
		
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getallproducts(){
		
		
        List<Product> plist =  ps.getAll();
	
	return new ResponseEntity(plist, HttpStatus.OK);
}

}
