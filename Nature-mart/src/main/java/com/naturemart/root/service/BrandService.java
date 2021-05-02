package com.naturemart.root.service;

import java.util.List;


import com.naturemart.root.entity.Brand;




public interface BrandService {
	
	public List<Brand> getAll();
	public Brand getperbyId(Integer id);
	public Brand save(Brand p);
	public void remove(Brand p);
    public void remove(Integer id);

}
