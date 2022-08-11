package com.samples.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="houseno", column=@Column(name="billing_houseno")),
		@AttributeOverride(name="street", column=@Column(name="billing_street")),
		@AttributeOverride(name="city", column=@Column(name="billing_city")),
		@AttributeOverride(name="pincode", column=@Column(name="billing_pincode"))
	})
	private address billingaddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="houseno", column=@Column(name="shipping_houseno")),
		@AttributeOverride(name="street", column=@Column(name="shipping_street")),
		@AttributeOverride(name="city", column=@Column(name="shipping_city")),
		@AttributeOverride(name="pincode", column=@Column(name="shipping_pincode"))
	})
	private address shippingaddress;
	
	public user() {}

	public user(String name, address billingaddress, address shippingaddress) {
		this.name = name;
		this.billingaddress = billingaddress;
		this.shippingaddress = shippingaddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public address getBillingaddress() {
		return billingaddress;
	}

	public void setBillingaddress(address billingaddress) {
		this.billingaddress = billingaddress;
	}

	public address getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(address shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", billingaddress=" + billingaddress + ", shippingaddress="
				+ shippingaddress + "]";
	}
	
	
}
