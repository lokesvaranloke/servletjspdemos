package com.sessions.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/demoservlet")
public class demoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String name=(String) session.getAttribute("user");
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		pw.println("Your username is "+name);
//		int age=(int) session.getAttribute("age");
//		pw.println("Your age is "+age);
		
		Cookie[] cookies = request.getCookies();
		Cookie mycookie = cookies[1];
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("User name is "+mycookie.getValue());
	}

}
