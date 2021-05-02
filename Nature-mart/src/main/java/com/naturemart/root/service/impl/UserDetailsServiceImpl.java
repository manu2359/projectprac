package com.naturemart.root.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.naturemart.root.entity.GrantedAuthorityimpl;
import com.naturemart.root.entity.UserDetailsImpl;
import com.naturemart.root.repository.UserDetailsRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailsRepo userDetailsRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		UserDetailsImpl userDetails = userDetailsRepo.findByUsername(username);
		  if(userDetails == null) {
			  return null;
		  }
		  else {
	   List<GrantedAuthorityimpl> authorities = userDetailsRepo.getGrantedAuthorities(username);
	    userDetails.setAuthorities(authorities);
		  }
		  userDetails.setPassword("{noop}"+userDetails.getPassword());	  
		return userDetails;
	}
	
}
