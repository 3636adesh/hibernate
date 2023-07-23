package com.malunjkar.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cheque_payments")
@PrimaryKeyJoinColumn(name = "txid")
public class ChequePayment extends Payment {

	private String chequeNo;
	private String accNo;


	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", accNo=" + accNo + ", getChequeNo()=" + getChequeNo()
				+ ", getAccNo()=" + getAccNo() + "]";
	}
	
	
	
	

	
}
