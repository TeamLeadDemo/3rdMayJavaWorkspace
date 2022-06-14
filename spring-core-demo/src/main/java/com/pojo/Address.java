package com.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

	private String city;
	private int  zipcode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(String city, int zipcode) {
		super();
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	//@Value("St.Louis") // equivalent to property/setter injection of values in xml file
	public void setCity(String city) {
		this.city = city;
	}

	
	public int getZipcode() {
		return zipcode;
	}

	//@Value("66366")
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", zipcode=" + zipcode + "]";
	}
	
	
	
	
}
