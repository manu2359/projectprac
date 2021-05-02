package com.naturemart.root.service;

import com.naturemart.root.entity.AccountDetails;
import com.naturemart.root.entity.UserDetailsImpl;

public interface UserDetailsRegistrationService {

	public void saveuserdetails(UserDetailsImpl userdetailsimpl,AccountDetails details);
	
}
