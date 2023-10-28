package com.npci.loanapplication.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npci.loanapplication.beans.Customer;
import com.npci.loanapplication.dao.CustomerDao;
import com.npci.loanapplication.service.CustomerService;

public class CustomerTestCases {
	
	private static ApplicationContext context;
	
	private CustomerDao customerDao;

	private CustomerService service;
	
	@BeforeAll
	public static void load() {
		context= new ClassPathXmlApplicationContext("spring-orm-beans2.xml");
	}
	@AfterAll
	public static void unload() {
		ClassPathXmlApplicationContext context2= (ClassPathXmlApplicationContext)context;
		context2.close();
	}

	@BeforeEach
	public  void initializeEmployee() {
		customerDao = (CustomerDao)context.getBean("b2");
	}
	
	@AfterEach
	public void deinitializeEmployee() {
		customerDao=null;
	}
	
	
	@Test
	public void testSave() {
		Customer customer= new Customer(1, "Ashwini ","Kale", "ashwini@gmail.com", "ashwini@123", 987676," ksvpk67");
        service.createCustomer(customer);
        List<Customer> profiles = service.findCustomer();
        assertEquals(1, profiles.size());
	}
	
	@Test
	public void validateLogin() {
		try {
		Customer customer = new Customer(1, "Ashwini ","Kale", "ashwini@gmail.com", "ashwini@123", 987676," ksvpk67");
		service.createCustomer(customer);
		fail("Invalid Customer Details should not be Saved");
		}catch(IllegalArgumentException e) {
			System.out.println("Invalid Customer Details");
		}
		
	}
	

}
