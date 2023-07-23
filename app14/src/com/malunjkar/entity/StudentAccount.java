package com.malunjkar.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "std")
public class StudentAccount extends Account {

	private int sId;
	private String sbranch;
	private double smarks;
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getSbranch() {
		return sbranch;
	}
	public void setSbranch(String sbranch) {
		this.sbranch = sbranch;
	}
	public double getSmarks() {
		return smarks;
	}
	public void setSmarks(double smarks) {
		this.smarks = smarks;
	}
	@Override
	public String toString() {
		return "StudentAccount [sId=" + sId + ", sbranch=" + sbranch + ", smarks=" + smarks + ", getAccNo()="
				+ getAccNo() + ", getAccType()=" + getAccType() + ", getAccName()=" + getAccName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
