package com.samples.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readuserservlet")
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn=null;
	@Override
	public void init() throws ServletException {
		
		try {
			System.out.println("ReadUserServlet.init() method. DB connection created");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet");
		try(Statement st = conn.createStatement();) {
			
			ResultSet rs = st.executeQuery("select * from user");
			PrintWriter pw = response.getWriter();
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<th>First Name</th>");
			pw.println("<th>Last Name</th>");
			pw.println("<th>Email</th>");
			pw.println("</tr>");
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>" + rs.getString(1) + "</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.write("<p><a href=\"userHome.html\">Home</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void destroy() {
		System.out.println("ReadUserServlet.destroy() method. DB connected closed");
	}

}
