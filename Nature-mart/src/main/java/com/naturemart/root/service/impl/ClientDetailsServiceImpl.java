package com.naturemart.root.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.naturemart.root.entity.ClientDetailsGrantedAuthority;
import com.naturemart.root.entity.ClientDetailsImpl;
import com.naturemart.root.repository.ClientDetailsRepo;


@Service
public class ClientDetailsServiceImpl implements ClientDetailsService{
	
	@Autowired
	private ClientDetailsRepo clientDetailsRepo;

	@Override
	public ClientDetails loadClientByClientId(String clientID) throws ClientRegistrationException {
		
     ClientDetailsImpl clientDetailsImpl = clientDetailsRepo.findByClientId(clientID);
		
   if (clientDetailsImpl == null) return null;
		
   else {
			Collection<ClientDetailsGrantedAuthority> authorities = clientDetailsRepo.getAuthories(clientID);
			Collection<GrantedAuthority> grants = new ArrayList<>();
			grants.addAll(authorities);
			clientDetailsImpl.setAuthorities(grants);
			Set<String> scopes = new HashSet<>();
			scopes.add("resource-server-read");
			scopes.add("resource-server-write");
			clientDetailsImpl.setScope(scopes);
			clientDetailsImpl.setClientSecret("{noop}"+clientDetailsImpl.getClientSecret());
			
			Set<String> grantTypes = new HashSet<>();
			grantTypes.add("client_credentials");
			grantTypes.add("password");
			clientDetailsImpl.setAuthorizedGrantTypes(grantTypes);
			
		}
		
		return clientDetailsImpl;
	}
	
}
