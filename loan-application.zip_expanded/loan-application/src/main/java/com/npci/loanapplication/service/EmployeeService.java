package com.npci.loanapplication.service;



import java.util.List;

import com.npci.loanapplication.beans.Customer;
import com.npci.loanapplication.beans.Employee;
import com.npci.loanapplication.exceptions.EmployeeNotFound;

public interface EmployeeService {
	
	
	List<Employee>findEmployee();
	Employee createEmployee(Employee employee);
	Employee findByEmailId(String emailid);
	Employee LoginEmployee(String emailid,String password) throws EmployeeNotFound;

}
