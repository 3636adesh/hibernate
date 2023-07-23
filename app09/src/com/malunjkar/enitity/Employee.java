package com.malunjkar.enitity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emps")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "e_no")
	private int eno;
	@Column(name = "e_name")
	private String ename;
	@Column(name = "e_sal")
	private double esal;
	@Column(name = "e_add")
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

	public double getEsal() {
		return esal;
	}

	public void setEsal(double esal) {
		this.esal = esal;
	}

	public String getEadd() {
		return eadd;
	}

	public void setEadd(String eadd) {
		this.eadd = eadd;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", esal=" + esal + ", eadd=" + eadd + "]";
	}

}
