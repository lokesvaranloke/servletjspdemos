package com.samples.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="registration_id", nullable = false)
	private String regid;
	
	private String name;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="guide_id")
	private guide guide;
	
	public student() {}

	public student(String regid, String name, com.samples.domain.guide guide) {
		this.regid = regid;
		this.name = name;
		this.guide = guide;
	}
	
	
}
