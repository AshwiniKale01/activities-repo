package com.npci.loanapplication.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditScore {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="pan")
	private String pan;
	@Column(name="score")
	private int score;
	public CreditScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditScore(String pan, int score) {
		super();
		this.pan = pan;
		this.score = score;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "CreditScore [pan=" + pan + ", score=" + score + "]";
	}
	
	
}
