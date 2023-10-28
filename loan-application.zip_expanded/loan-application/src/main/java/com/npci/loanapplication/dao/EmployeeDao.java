package com.npci.loanapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.npci.loanapplication.beans.Customer;
import com.npci.loanapplication.beans.Employee;


public interface EmployeeDao extends JpaRepository<Employee,Integer> {
	

	@Query("select e from Employee e  where e.emailid =?1")
	public Employee findByEmailId(String emailid);

}
