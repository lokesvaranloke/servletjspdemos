package com.samples.domain;

import java.util.List;

public class book {

	private String isbn;
	private String name;
	private publisher publisher;
	private List<chapter> chapters;
	
	public book(String isbn, String name, com.samples.domain.publisher publisher) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
	}

	public book() {
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(publisher publisher) {
		this.publisher = publisher;
	}

	public List<chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		return "book [isbn=" + isbn + ", name=" + name + ", publisher=" + publisher + ", chapters=" + chapters + "]";
	}
	
	
	
}
