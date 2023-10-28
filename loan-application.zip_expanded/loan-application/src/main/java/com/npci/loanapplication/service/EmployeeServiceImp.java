package com.npci.loanapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.npci.loanapplication.beans.Customer;
import com.npci.loanapplication.beans.Employee;
import com.npci.loanapplication.dao.EmployeeDao;

import com.npci.loanapplication.exceptions.EmployeeNotFound;

//@EnableJpaRepositories

@Service("Empservice")

public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired(required=true)
	private EmployeeDao dao;


	@Override
	public Employee LoginEmployee(String emailid, String password) throws EmployeeNotFound {
		Employee emp = dao.findByEmailId(emailid);
		if(emp==null) {
			throw new EmployeeNotFound("EmailId is wrong");
		}else if(!emp.getPassword().equals(password)) {
			throw new EmployeeNotFound("Password is wrong");
		}else {
			return emp;
		}
	}


	@Override
	public Employee findByEmailId(String emailid) {
		Employee emp = dao.findByEmailId(emailid);
		return emp;
	}


	@Override
	public Employee createEmployee(Employee employee) {
		
		return dao.save(employee);
	}


	@Override
	public List<Employee> findEmployee() {
		
		return dao.findAll();
	}

}
