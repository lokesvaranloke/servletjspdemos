package com.samples.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class guide {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="staffid", nullable = false)
	private String staffid;
	
	@Column
	private String name;
	
	@Column
	private Integer salary;
	
	@OneToMany(mappedBy = "guide", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<student> students = new HashSet<>();
	
	public guide() {}
	
	public guide(String staffid, String name, Integer salary) {
		this.staffid = staffid;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "guide [id=" + id + ", staffid=" + staffid + ", name=" + name + ", salary=" + salary + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Set<student> getStudents() {
		return students;
	}

	public void setStudents(Set<student> students) {
		this.students = students;
	}
	
	
}
