package com.naturemart.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.naturemart.root.entity.GrantedAuthorityimpl;
import com.naturemart.root.entity.UserDetailsImpl;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetailsImpl, Integer>  {
	
	
	 public UserDetailsImpl findByUsername(String username);
	
	 @Query("select a from UserDetailsImpl u join u.authorities a where u.username=?1 ")
	 public List<GrantedAuthorityimpl> getGrantedAuthorities(String username);

}
