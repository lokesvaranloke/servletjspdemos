package com.samples.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adduserservlet") 
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			ServletContext context = config.getServletContext();
			System.out.println("ReadUserServlet.init() method. DB connection created");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(context.getInitParameter("dburl"), context.getInitParameter("dbuname"),
					context.getInitParameter("dbpass"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try (PreparedStatement st = conn.prepareStatement("insert into user value (?,?,?,?)");) {

			st.setString(1, firstname);
			st.setString(2, lastname);
			st.setString(3, email);
			st.setString(4, password);
			int rowsInserted = st.executeUpdate();
			System.out.println("Number of rows inserted : " + rowsInserted);

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
