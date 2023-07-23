package com.malunjkar.entity;

import java.util.Set;

public class Student {

	private int stId;
	private String stdName;
	private String stAdd;
	private Set<Course> courses;
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStAdd() {
		return stAdd;
	}
	public void setStAdd(String stAdd) {
		this.stAdd = stAdd;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
