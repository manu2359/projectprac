package com.naturemart.root.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class ClientDetailsGrantedAuthority implements GrantedAuthority{
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String authority;

	@Override
	public String getAuthority() {
		
		return this.authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
