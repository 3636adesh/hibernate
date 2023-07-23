package com.malunjkar.entity;

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
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	/* 
	  @SequenceGenerator(name="seqGenerator" ,sequenceName = "sequence_inc_5")
	  @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seqGenerator")
	*/
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	/* 
	@TableGenerator(name="generatorTabale" ,table = "key_generator_01",pkColumnName = "id",pkColumnValue = "10",valueColumnName = "next_hi")
	@GeneratedValue(strategy = GenerationType.TABLE , generator = "generatorTabale")
	*/
	
	/* 
	@GenericGenerator(name = "incGenerator",strategy = "increment")
	@GeneratedValue(generator = "incGenerator")
	*/
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

}
