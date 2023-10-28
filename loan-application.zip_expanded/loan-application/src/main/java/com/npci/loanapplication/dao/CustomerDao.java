package com.npci.loanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.loanapplication.beans.Customer;

public interface CustomerDao  extends JpaRepository<Customer, Integer>{
	
	@Query("select p from Customer p  where p.emailid =?1")
	public Customer findByEmailId(String emailid);

}
