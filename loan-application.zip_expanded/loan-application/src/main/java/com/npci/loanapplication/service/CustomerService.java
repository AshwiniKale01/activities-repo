package com.npci.loanapplication.service;

import java.util.List;

import com.npci.loanapplication.beans.Customer;
import com.npci.loanapplication.exceptions.CustomerNotFoundException;

public interface CustomerService {
	
	List<Integer> createCustomers(Customer customer1,Customer...customers);
	Customer createCustomer(Customer customer);
//	Customer findCustomer(int id) throws CustomerNotFoundException;
	void deleteCustomer(int id)throws CustomerNotFoundException;
//	List<Customer>findCustomerByName(String name);
	List<Customer>findCustomer();
	
	Customer findByEmailId(String emailid);
	Customer LoginCustomer(String emailid,String password) throws CustomerNotFoundException;


}
