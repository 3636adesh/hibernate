package com.malunjkar.entity;

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
	
}
