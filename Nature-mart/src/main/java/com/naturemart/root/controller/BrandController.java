package com.naturemart.root.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.naturemart.root.entity.Brand;

import com.naturemart.root.service.BrandService;


import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@RequestMapping("brand")
public class BrandController {
	
	@Autowired
	private BrandService ps;
	
	@PostMapping("/savebrand")
	public ResponseEntity<Brand> savebrand(@RequestBody Brand p) {
		
		Brand p2=ps.save(p);
		
		return new ResponseEntity(p2 , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deletepro(@PathVariable Integer id){
		
		   ps.remove(id);
		
		return new ResponseEntity(id , HttpStatus.OK);
	}
	
	@GetMapping("/getone/{id}")
	public ResponseEntity<Brand> getBrand(@PathVariable Integer id){
		  
		System.out.println("controller working");
		
              Brand p =  ps.getperbyId(id);
		
		return new ResponseEntity<Brand>(p, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Brand>> getallBrands(){
		
		
        List<Brand> plist =  ps.getAll();
	
	return new ResponseEntity(plist, HttpStatus.OK);
}


}
