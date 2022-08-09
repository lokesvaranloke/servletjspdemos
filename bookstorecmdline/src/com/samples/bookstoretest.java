package com.samples;

import java.util.ArrayList;
import java.util.List;

import com.samples.domain.book;
import com.samples.domain.chapter;
import com.samples.domain.publisher;
import com.samples.service.bookstoreservice;

public class bookstoretest {
	
	public static void main(String[] args) {
		
		bookstoreservice bookstoreservice = new bookstoreservice();
		book book = bookstoreservice.getbook("isbn-0011jd1234");
		System.out.println(book);
	}

	public static void savebook() {
		
		publisher publisher = new publisher("Mann", "Manning");
		
		book book = new book("isbn-0011jd1234","Java Bible", publisher);
		
		List<chapter> chapters = new ArrayList<>();
		chapter c1 = new chapter(1, "Introduction");
		chapter c2 = new chapter(2, "Datatypes");
		chapter c3 = new chapter(3, "Loops");
		chapters.add(c1);
		chapters.add(c2);
		chapters.add(c3);
		
		book.setChapters(chapters);
		
		bookstoreservice bookstoreservice = new bookstoreservice();
		bookstoreservice.addbook(book);
	}
}
