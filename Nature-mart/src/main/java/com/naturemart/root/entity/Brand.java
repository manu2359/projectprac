package com.naturemart.root.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Brand {

	@Id
	@GeneratedValue
	private Integer id;
	private String brandname;
	
    
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable( 
	    name="brand_cat",
		joinColumns = {@JoinColumn(name="bid")},
		inverseJoinColumns = {@JoinColumn(name="cid")}
			
			)
	private List<Category> catlist; 

	public List<Category> getCatlist() {
		return catlist;
	}

	public void setCatlist(List<Category> catlist) {
		this.catlist = catlist;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	

}
