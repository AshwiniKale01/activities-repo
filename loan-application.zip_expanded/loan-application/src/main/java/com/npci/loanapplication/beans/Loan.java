package com.npci.loanapplication.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="loanid")
	private int loanid;
	@Column(name="loantype")
	private String loantype;	

//	superclass constructor
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

//	constructor with field
	public Loan(int loanid, String loantype) {
		super();
		this.loanid = loanid;
		this.loantype = loantype;
	}

	public int getLoanid() {
		return loanid;
	}

	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	@Override
	public String toString() {
		return "Loan [loanid=" + loanid + ", loantype=" + loantype + "]";
	}

}
