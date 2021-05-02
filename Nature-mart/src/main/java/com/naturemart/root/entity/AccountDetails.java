package com.naturemart.root.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class AccountDetails {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String profilepic;
	
	private String name;
	
	private String Email;
	
	private Long phone;
	
	private String address;
	
	
	@OneToOne
	@JoinColumn(name="ucred")
	private UserDetailsImpl usercredentials;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable( 
	    name="account_product",
		joinColumns = {@JoinColumn(name="aid")},
		inverseJoinColumns = {@JoinColumn(name="pid")}
			
			)
	private List<Product> cart;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserDetailsImpl getUsercredentials() {
		return usercredentials;
	}

	public void setUsercredentials(UserDetailsImpl usercredentials) {
		this.usercredentials = usercredentials;
	}

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}
}
