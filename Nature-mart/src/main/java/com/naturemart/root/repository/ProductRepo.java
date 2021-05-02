package com.naturemart.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.naturemart.root.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query("from Product p where p.name like ?1%")
	public List<Product> findByNamelike(String name);
	
	@Query("select p.name,p.cost from Product p join p.brand b join b.catlist c where c.categoryname like ?1%")
	public List<Object[]> Namelikecategory(String name);
	
	@Query("select p.name,p.cost from Product p join p.brand b where b.brandname like ?1")
	public List<Object[]> Namebrand(String name);

}
