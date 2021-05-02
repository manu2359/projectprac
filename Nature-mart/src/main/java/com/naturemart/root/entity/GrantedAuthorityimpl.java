package com.naturemart.root.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name="usergrantedauthority")
public class GrantedAuthorityimpl implements GrantedAuthority{

	@Id
	@GeneratedValue
	private Integer id;
	
	private String Authority;
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setAuthority(String authority) {
		Authority = authority;
	}


	
	
	
	@Override
	public String getAuthority() {
		
		return this.Authority;
	}
	
	

}
