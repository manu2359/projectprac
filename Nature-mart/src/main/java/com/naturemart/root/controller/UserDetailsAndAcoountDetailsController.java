package com.naturemart.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturemart.root.entity.AccountDetails;
import com.naturemart.root.entity.UserDetailsImpl;
import com.naturemart.root.service.UserDetailsRegistrationService;

@RestController
@RequestMapping("useraccount")
public class UserDetailsAndAcoountDetailsController {
	
	@Autowired
	private UserDetailsRegistrationService userdetailsreg;
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public void saveUserAndAccount(UserDetailsImpl userdetailsimpl,AccountDetails details) {
		
		userdetailsreg.saveuserdetails(userdetailsimpl, details);
		
		
	}

}
