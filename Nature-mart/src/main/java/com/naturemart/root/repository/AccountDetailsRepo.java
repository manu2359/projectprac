package com.naturemart.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naturemart.root.entity.AccountDetails;

@Repository
public interface AccountDetailsRepo extends JpaRepository<AccountDetails,Integer>{

}
