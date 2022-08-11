package com.samples.service;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Book;
import com.samples.utils.hibernateutil;

public class BookstoreService {

	public void addBook(Book book) {
		Session session = hibernateutil.getSessionFacatory().openSession();

		Transaction tn = session.getTransaction();

		try {

			tn.begin();

			session.save(book);

			tn.commit();

		} catch (Exception ex) {
			if (tn != null) {
				tn.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	public List<Book> getBooks() {
		
		List<Book> books = null;
		
		Session session = hibernateutil.getSessionFacatory().openSession();

		Transaction tn = session.getTransaction();

		try {

			tn.begin();

			books = session.createQuery("from Book").list();

			tn.commit();

		} catch (Exception ex) {
			if (tn != null) {
				tn.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return books;
		
	}

	
}
