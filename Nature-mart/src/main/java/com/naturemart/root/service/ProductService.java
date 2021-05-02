package com.naturemart.root.service;

import java.util.List;




import com.naturemart.root.entity.Product;



public interface ProductService {
	
	public List<Product> getAll();
	public Product getperbyId(Integer id);
	public Product save(Product p);
	public void remove(Product p);
    public void remove(Integer id);
    public List<Product> Namelike(String name);
    public List<Object[]> brandNamelike(String name);
    public List<Object[]> categoryNamelike(String name);
    

}
