package com.npci.loanapplication.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoanApplication {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="applicationid")
	private int applicationid;
	@Column(name="customerid_re")
	private int customerid_ref;
	@Column(name="loanid_ref")
	private int loanid_ref;
	@Column(name="status")
	private String status;
	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoanApplication(int applicationid, int customerid_ref, int loanid_ref, String status) {
		super();
		this.applicationid = applicationid;
		this.customerid_ref = customerid_ref;
		this.loanid_ref = loanid_ref;
		this.status = status;
	}
	public int getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}
	public int getCustomerid_ref() {
		return customerid_ref;
	}
	public void setCustomerid_ref(int customerid_ref) {
		this.customerid_ref = customerid_ref;
	}
	public int getLoanid_ref() {
		return loanid_ref;
	}
	public void setLoanid_ref(int loanid_ref) {
		this.loanid_ref = loanid_ref;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoanApplication [applicationid=" + applicationid + ", customerid_ref=" + customerid_ref
				+ ", loanid_ref=" + loanid_ref + ", status=" + status + "]";
	}
	

}
