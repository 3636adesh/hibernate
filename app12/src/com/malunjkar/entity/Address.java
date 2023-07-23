package com.malunjkar.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Entity
public class Address {

	private String street;
	private String phone;
	private String city;

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
