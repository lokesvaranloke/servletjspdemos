<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2> The student registration is confirmed </h2> 
	Welcome ${param.firstname} ${param.lastname}
	<br/>
	Welcome <%= request.getParameter("firstname") %> <%= request.getParameter("lastname") %>
	<br/>
	<p>Your country is ${param.country}</p>
	<br/>
	Your favourite languages are :
	<ul>
		<%
			String[] lang = request.getParameterValues("language");
			for(String l : lang){
				out.println("<li>" + l + "</li>");
			}
		%>
	</ul>
</body>
</html>