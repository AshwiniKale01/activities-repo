package com.npci.loanapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.loanapplication.beans.Customer;
import com.npci.loanapplication.dao.CustomerDao;
import com.npci.loanapplication.exceptions.CustomerNotFoundException;


@Service("custservice")
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerDao dao;

	@Override
	public List<Integer> createCustomers(Customer customer1, Customer... customers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		
		return dao.save(customer);
	}

	@Override
	public void deleteCustomer(int id) throws CustomerNotFoundException {
		
		
	}

	@Override
	public List<Customer> findCustomer() {
		
		return dao.findAll();
	}

	@Override
	public Customer findByEmailId(String emailid) {
		Customer cs = dao.findByEmailId(emailid);
		return cs;
	}

	@Override
	public Customer LoginCustomer(String emailid, String password) throws CustomerNotFoundException {
		Customer cs = dao.findByEmailId(emailid);
		if(cs==null) {
			throw new CustomerNotFoundException("EmailId is wrong");
		}else if(!cs.getPassword().equals(password)) {
			throw new CustomerNotFoundException("Password is wrong");
		}else {
			return cs;
		}
		
	}
	
	

}
