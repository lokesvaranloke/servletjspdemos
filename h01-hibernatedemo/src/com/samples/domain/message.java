package com.samples.domain;

public class message {

	private int id;
	private String text;
	
	public message(String text) {
		super();
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "message [id=" + id + ", text=" + text + "]";
	}
	
	
}
