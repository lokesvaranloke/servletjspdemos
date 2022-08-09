package com.samples.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.samples.domain.book;
import com.samples.domain.chapter;
import com.samples.domain.publisher;

public class bookstoreservice {

	public void addbook(book book) {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bookstore", "root", "root");
			
			PreparedStatement st = conn.prepareStatement("insert into publisher (code, publisher_name) values (?,?)");
			st.setString(1, book.getPublisher().getCode());
			st.setString(2, book.getPublisher().getName());
			st.executeUpdate();
			st.close();
			
			st = conn.prepareStatement("insert into book(isbn, book_name, publisher_code) values (?,?,?)");
			st.setString(1, book.getIsbn());
			st.setString(2, book.getName());
			st.setString(3, book.getPublisher().getCode());
			st.executeUpdate();
			st.close();
			
			st = conn.prepareStatement("insert into chapter (book_isbn, chapter_num, title) values (?,?,?)");
			for(chapter chapter : book.getChapters()) {
				st.setString(1, book.getIsbn());
				st.setInt(2, chapter.getChapternumber());
				st.setString(3, chapter.getTitle());
				st.executeUpdate();
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public book getbook(String isbn) {
		Connection conn = null;
		book book = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bookstore", "root", "root");
			PreparedStatement st = conn.prepareStatement("select * from book inner join publisher on book.publisher_code = publisher.code and book.isbn = ?;");
			st.setString(1, isbn);
			
			ResultSet rs = st.executeQuery();
			book = new book();
			
			while(rs.next()) {
				book.setIsbn(rs.getString("isbn"));
				book.setName(rs.getString("book_name"));
				
				publisher publisher = new publisher();
				publisher.setCode(rs.getString("code"));
				publisher.setName(rs.getString("publisher_name"));
				book.setPublisher(publisher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
	}

	
}
