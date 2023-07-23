package com.malunjkar.entity;

public class Customer extends Person {

	private String cname;
	private String cadd;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCadd() {
		return cadd;
	}

	public void setCadd(String cadd) {
		this.cadd = cadd;
	}

	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", cadd=" + cadd + ", getCname()=" + getCname() + ", getCadd()=" + getCadd()
				+ "]";
	}

}
