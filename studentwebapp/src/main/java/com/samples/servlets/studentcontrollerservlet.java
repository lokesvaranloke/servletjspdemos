package com.samples.servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.samples.datalayer.studentdbutil;
import com.samples.model.student;



@WebServlet("/studentcontrollerservlet")
public class studentcontrollerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private studentdbutil stddbutil;

	@Resource(name="jdbc/studentwebapp")
	private DataSource dataSource;
	
	public void init() throws ServletException {
		super.init();
		this.stddbutil=new studentdbutil(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<student> students = stddbutil.getstudents();
		request.setAttribute("STUDENT_LIST", students);
		
		RequestDispatcher rd = request.getRequestDispatcher("/list-students.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		student s1 = new student(0, firstname, lastname, email);
		stddbutil.addstudent(s1);
		doGet(request, response);
	}

}
