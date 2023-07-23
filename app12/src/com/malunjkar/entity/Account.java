package com.malunjkar.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Entity
public class Account {

	private int accNo;
	private String accName;
	private String accType;

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

}
