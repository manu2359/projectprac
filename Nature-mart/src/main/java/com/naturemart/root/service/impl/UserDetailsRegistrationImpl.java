package com.naturemart.root.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naturemart.root.entity.AccountDetails;
import com.naturemart.root.entity.UserDetailsImpl;
import com.naturemart.root.repository.AccountDetailsRepo;
import com.naturemart.root.repository.UserDetailsRepo;
import com.naturemart.root.service.UserDetailsRegistrationService;

@Service
public class UserDetailsRegistrationImpl implements UserDetailsRegistrationService{
    
	@Autowired
	private UserDetailsRepo userdetailrepo;
	
	@Autowired
	private AccountDetailsServiceImpl accdetails;
	
	@Override
	@Transactional
	public void saveuserdetails(UserDetailsImpl userdetailsimpl, AccountDetails details) {
		
		userdetailrepo.save(userdetailsimpl);
		
		accdetails.saveaccount(details);
		
	}

}
