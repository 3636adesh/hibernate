package com.malunjkar.entity;

public class EmployeeAccount extends Account {

	private int eno;
	private String ename;
	private double esal;
	private String eadd;
	
	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEadd() {
		return eadd;
	}

	public void setEadd(String eadd) {
		this.eadd = eadd;
	}

	public double getEsal() {
		return esal;
	}

	public void setEsal(double esal) {
		this.esal = esal;
	}

	@Override
	public String toString() {
		return "EmployeeAccount [eno=" + eno + ", ename=" + ename + ", esal=" + esal + ", eadd=" + eadd
				+ ", getAccNo()=" + getAccNo() + ", getAccType()=" + getAccType() + ", getAccName()=" + getAccName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
