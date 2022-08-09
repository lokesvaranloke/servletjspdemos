package com.samples.domain;

public class publisher {

	private String code;
	private String name;
	
	public publisher(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public publisher() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "publisher [code=" + code + ", name=" + name + "]";
	}
	
	
}
