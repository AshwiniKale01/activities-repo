package com.npci.loanapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.loanapplication.beans.Customer;
import com.npci.loanapplication.exceptions.CustomerNotFoundException;
import com.npci.loanapplication.service.CustomerService;

@CrossOrigin(origins= {"*"})
@RestController("cust")
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	private List<String> exceptionsList = new ArrayList<>();
	
	@PostMapping(path = "/addcustomers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeCustomer(@RequestBody Customer customer) {
		Customer created = service.createCustomer(customer);
		return ResponseEntity.status(201).body(created);

	}
	@GetMapping(path = "/get/customers")
	public ResponseEntity<Object> getAllCustomer() {
		List<Customer> customers = service.findCustomer();
//			adding Profile in the response body -spring boot automatically converts List or any objects to JSON format
		return ResponseEntity.status(200).body(customers);
	}
	
//  method for login
	@PostMapping(path = "/login")
	public ResponseEntity<Object> LoginToCustomer(@RequestBody Customer customer) {
		Customer login=null;
		try {
			login = service.LoginCustomer(customer.getEmailid(), customer.getPassword());
		} catch (CustomerNotFoundException e) {
			System.out.println("Failure for login");
		}
		return ResponseEntity.status(200).body(login);
	}
}


