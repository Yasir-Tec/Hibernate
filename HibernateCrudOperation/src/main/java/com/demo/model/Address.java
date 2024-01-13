package com.demo.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;


@Embeddable
public class Address {
	
	private int addrid;
	private String city;
	private String street;
	
	public Address() {
		super();
	}

	public Address(int addrid, String city, String street) {
		super();
		this.addrid = addrid;
		this.city = city;
		this.street = street;
	}

	public int getAddrid() {
		return addrid;
	}

	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [addrid=" + addrid + ", city=" + city + ", street=" + street + "]";
	}
	
	
	

}
