package com.malunjkar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="accounts")
@Entity
public class Account {

	@Id
	private String accno;
	private String acctype;
	private double balance;

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accno=" + accno + ", acctype=" + acctype + ", balance=" + balance + ", getAccno()="
				+ getAccno() + ", getAcctype()=" + getAcctype() + ", getBalance()=" + getBalance() + "]";
	}

	
}
