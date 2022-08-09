package com.mvcdemo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcdemoservlet")
public class mvcdemoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] students= {"Harish","Vijay","Ram"};
		request.setAttribute("studentlist", students);
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewstudent.jsp");
		rd.forward(request, response);
	}

}
