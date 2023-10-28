package com.npci.loanapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.npci.loanapplication.beans.Employee;

import com.npci.loanapplication.exceptions.EmployeeNotFound;

import com.npci.loanapplication.service.EmployeeService;

@RestController("emp")
@RequestMapping("/api1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	private List<String> exceptionsList = new ArrayList<>();
	
	@PostMapping(path = "/addemployees", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeEmployee(@RequestBody Employee employee) {
		Employee created = service.createEmployee(employee);
		return ResponseEntity.status(201).body(created);

	}
	@GetMapping(path = "/get/employees")
	public ResponseEntity<Object> getAllEmployee() {
		List<Employee> customers = service.findEmployee();
//			adding Profile in the response body -spring boot automatically converts List or any objects to JSON format
		return ResponseEntity.status(200).body(customers);
	}
	
//  method for login
	@PostMapping(path = "/login/employee")
	public ResponseEntity<Object> LoginToEmployee(@RequestBody Employee employee) {
		Employee login=null;
		try {
			login = service.LoginEmployee(employee.getEmailid(), employee.getPassword());
		} catch (EmployeeNotFound e) {
			System.out.println("Failure for login");
		}
		return ResponseEntity.status(200).body(login);
	}

}
