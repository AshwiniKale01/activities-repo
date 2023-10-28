package com.npci.loanapplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LoanApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(LoanApplication.class, args);
		
		
	}

}
