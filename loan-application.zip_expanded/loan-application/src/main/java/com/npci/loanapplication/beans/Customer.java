package com.npci.loanapplication.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //auto-generate the id based on auto-increment
	@Column(name="customerid")
	private int customerid;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="emailid")
	private String emailid;
	@Column(name="password")
	private String password;
	@Column(name="phone")
	private long phone;
	@Column(name="pan")
	private String pan;
	

//	constructor of object class
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

//	constructor with fields 
	public Customer(int customerid, String firstname, String lastname, String emailid, String password, long phone,
			String pan) {
		super();
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.password = password;
		this.phone = phone;
		this.pan = pan;
	}
//getters method
	public int getCustomerid() {
		return customerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmailid() {
		return emailid;
	}

	public String getPassword() {
		return password;
	}

	public long getPhone() {
		return phone;
	}

	public String getPan() {
		return pan;
	}

//	setters method
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	private void firstName(String firstname) {
		if (firstname == null || firstname.length() < 3 || firstname.length() > 3) {
			throw new IllegalArgumentException("Name must be between 5 and 60 characters.");
		}
	}
	private void lastName(String lastname) {
		if (lastname == null || lastname.length() < 1 || lastname.length() > 3) {
			throw new IllegalArgumentException("Name must be between 5 and 60 characters.");
		}
	}

	private void Email(String emailid) {
		if (emailid == null || !emailid.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			throw new IllegalArgumentException("Invalid email format.");
		}
	}

	private void Password(String password) {
		if (password == null || password.length() < 8) {
			throw new IllegalArgumentException("Password must be at least 8 characters long.");
		}
	}

	private void Phone(String phone) {
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Phone must be a 10-digit number.");
		}
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	
//	toString to display the customer information
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", emailid=" + emailid + ", password=" + password + ", phone=" + phone + ", pan=" + pan + "]";
	}

	

}
