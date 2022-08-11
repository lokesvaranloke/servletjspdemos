package com.samples.domain;

import javax.persistence.Embeddable;

@Embeddable
public class address {

	private String houseno;
	private String street;
	private String city;
	private String pincode;
	
	public address() {}
	
	public address(String houseno, String street, String city, String pincode) {
		super();
		this.houseno = houseno;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}

	public String getHouseno() {
		return houseno;
	}

	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "address [houseno=" + houseno + ", street=" + street + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
	
}
