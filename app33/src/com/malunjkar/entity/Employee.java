package com.malunjkar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp1")
public class Employee {

	@Id
	@Column(name = "E_NO")
	private int eno;
	@Column(name = "E_NAME")
	private String ename;
	@Column(name = "E_ADD")
	private String eadd;
	@Column(name = "E_SAL")
	private double esal;

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
		return "Employee [eno=" + eno + ", ename=" + ename + ", eadd=" + eadd + ", esal=" + esal + "]";
	}

}
