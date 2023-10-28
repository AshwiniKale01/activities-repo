package com.npci.loanapplication.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@Column(name="employeeid")
	private int employeeid;
	@Column(name="employeenam")
	private String employeename;
	@Column(name="emailid")
	private String emailid;
	@Column(name="password")
	private String password;

//	superclass constructor 
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

//	constructor using field
	public Employee(int employeeid, String employeename, String emailid, String password) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.emailid = emailid;
		this.password = password;
	}

	
//	getters and setters method 
	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	private void employeeName(String name) {
		if (name == null || name.length() < 3 || name.length() > 3) {
			throw new IllegalArgumentException("Name must be between 5 and 60 characters.");
		}
	}

	public String getEmailid() {
		return emailid;
	}

	private void Email(String emailid) {
		if (emailid == null || !emailid.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			throw new IllegalArgumentException("Invalid email format.");
		}
	}

	public String getPassword() {
		return password;
	}

	private void Password(String password) {
		if (password == null || password.length() < 8) {
			throw new IllegalArgumentException("Password must be at least 8 characters long.");
		}
	}

//	toString to display the employee information
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", emailid=" + emailid
				+ ", password=" + password + "]";
	}

}
