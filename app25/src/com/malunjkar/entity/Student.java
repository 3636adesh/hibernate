package com.malunjkar.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	private int stId;
	private String stdName;
	private String stAdd;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course",joinColumns = {@JoinColumn(name="stId")},inverseJoinColumns = {@JoinColumn(name="cid")} )
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
