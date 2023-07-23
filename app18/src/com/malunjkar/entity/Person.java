package com.malunjkar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {


	@Id
	private String pName;
	private String pAdd;
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpAdd() {
		return pAdd;
	}
	public void setpAdd(String pAdd) {
		this.pAdd = pAdd;
	}
	
	

}
