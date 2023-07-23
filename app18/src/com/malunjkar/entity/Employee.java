package com.malunjkar.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee extends Person {


	private String empName;
	private double empSal;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empSal=" + empSal + ", getEmpName()=" + getEmpName()
				+ ", getEmpSal()=" + getEmpSal() + "]";
	}
	
	

	
}
