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

import com.naturemart.root.entity.Category;
import com.naturemart.root.entity.Category;
import com.naturemart.root.service.CategoryService;
import com.naturemart.root.service.CategoryService;

import io.swagger.annotations.Api;

@RestController  // tells this is controller class
@CrossOrigin
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService ps;
	
	@PostMapping("/savecat")
	public ResponseEntity<Category> savecat(@RequestBody Category p) {
		
		Category p2=ps.save(p);
		
		return new ResponseEntity(p2 , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deletepro(@PathVariable Integer id){
		
		   ps.remove(id);
		
		return new ResponseEntity(id , HttpStatus.OK);
	}
	
	@GetMapping("/getone/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable Integer id){
		  
		System.out.println("controller working");
		
              Category p =  ps.getperbyId(id);
		
		return new ResponseEntity<Category>(p, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Category>> getallCategorys(){
		
		
        List<Category> plist =  ps.getAll();
	
	return new ResponseEntity(plist, HttpStatus.OK);
}

}
