package com.naturemart.root.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturemart.root.entity.AccountDetails;
import com.naturemart.root.repository.AccountDetailsRepo;
import com.naturemart.root.service.AccountDetailsService;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService{
	
	@Autowired
	private AccountDetailsRepo adr;

	@Override
	public AccountDetails saveaccount(AccountDetails accdetails) {
		
		AccountDetails ad=adr.save(accdetails);
		
		return ad;
	}

	@Override
	public AccountDetails Findaccountbyid(Integer id) { 
		
	
       Optional<AccountDetails> ad=adr.findById(id);
       
       if(ad.isPresent()) {
    	   
    	   return ad.get();
    	   
       }else {
    	   
    	    new RuntimeException("There is no account found with this id");
    	    
    	    return null;
       }
		
		
	}

	@Override
	public List<AccountDetails> findallaccounts() { 
		
		
	      List<AccountDetails> ad=adr.findAll();
	       
	       if(ad.isEmpty()) {
	    	   
	    	   new RuntimeException("There are no accounts found");
	    	   
	    	   return null;
	    	   
	       }else{
	    	    
	    	    return ad;
	       }
			
			
		}

	
	

}
