package com.samples.domain;

public class chapter {

	private int chapternumber;
	private String title;
	
	public chapter(int chapternumber, String title) {
		super();
		this.chapternumber = chapternumber;
		this.title = title;
	}

	public int getChapternumber() {
		return chapternumber;
	}

	public void setChapternumber(int chapternumber) {
		this.chapternumber = chapternumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "chapter [chapternumber=" + chapternumber + ", title=" + title + "]";
	}
	
	
	
}
