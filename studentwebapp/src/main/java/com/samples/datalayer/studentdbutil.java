package com.samples.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.samples.model.student;

public class studentdbutil {

	private DataSource datasource;

	public studentdbutil(DataSource datasource) {
		this.datasource = datasource;
	}

	public List<student> getstudents() {
		List<student> students = new ArrayList<>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = datasource.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from student");

			while (rs.next()) {
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String email = rs.getString(4);

				student s = new student(id, firstname, lastname, email);
				students.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}

		return students;
	}

	private void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addstudent(student s1) {
		Connection conn=null;
		PreparedStatement st=null;
		
		try {
			conn=datasource.getConnection();
			String sql = "insert into student (firstname, lastname, email) values (?,?,?)";
			st = conn.prepareStatement(sql);
			
			st.setString(1, s1.getFirstname());
			st.setString(2, s1.getLastname());
			st.setString(3, s1.getEmail());
			
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, st, null);
		}
		
	}

}
