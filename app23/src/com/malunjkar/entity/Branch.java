package com.malunjkar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class Branch {

	@Id
	private String brId;
	private String brName;
	
	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public String getBrId() {
		return brId;
	}

	public void setBrId(String brId) {
		this.brId = brId;
	}

	@Override
	public String toString() {
		return "Branch [brId=" + brId + ", brName=" + brName + "]";
	}
	
	

}
