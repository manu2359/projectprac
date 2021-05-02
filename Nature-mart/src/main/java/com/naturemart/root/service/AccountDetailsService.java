package com.naturemart.root.service;

import java.util.List;

import com.naturemart.root.entity.AccountDetails;

public interface AccountDetailsService {
	
	public AccountDetails saveaccount(AccountDetails accdetails);
	
	public AccountDetails Findaccountbyid(Integer id);
	
	public List<AccountDetails> findallaccounts();

}
