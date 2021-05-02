package com.naturemart.root.repository;

import java.util.Collection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.naturemart.root.entity.ClientDetailsGrantedAuthority;
import com.naturemart.root.entity.ClientDetailsImpl;

@Repository
public interface ClientDetailsRepo extends JpaRepository<ClientDetailsImpl,Integer>{
	
	
	   public ClientDetailsImpl findByClientId(String clientId);
	   
	   @Query("select a from ClientDetailsImpl c join c.clientDetailsGrantedAuthority a where c.clientId=?1")
	   public Collection<ClientDetailsGrantedAuthority> getAuthories(String clientId);
	
	
	
	

}
