package com.malunjkar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {

	@Id
	private String stdname;
	private String stdadd;
	@ManyToOne(cascade = CascadeType.ALL)
	private Branch branch;

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public String getStdadd() {
		return stdadd;
	}

	public void setStdadd(String stdadd) {
		this.stdadd = stdadd;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student [stdname=" + stdname + ", stdadd=" + stdadd + ", branch=" + branch + ", getStdname()="
				+ getStdname() + ", getStdadd()=" + getStdadd() + ", getBranch()=" + getBranch() + "]";
	}

	
	
}
