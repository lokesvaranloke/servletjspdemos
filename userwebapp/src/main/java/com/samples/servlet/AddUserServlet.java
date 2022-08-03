package com.samples.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adduserservlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection conn=null;
	@Override
	public void init() throws ServletException {
		
		try {
			System.out.println("AddUserServlet.init() method. DB connection created");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		try(Statement st = conn.createStatement();) {
			
			String query="insert into user value('"+ firstname + "','"+ lastname + "','" + email + "','" + password+"')";
			System.out.println("Query being executed : "+query);
			int rowsInserted = st.executeUpdate(query);
			System.out.println("Number of rows inserted : "+rowsInserted);
			
			PrintWriter pw = response.getWriter();
			pw.println("User successfully Added");
			pw.write("<p><a href=\"userHome.html\">Home</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void destroy() {
		System.out.println("AddUserServlet.destroy() method. DB connected closed");
	}

}
