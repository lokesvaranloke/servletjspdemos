<%@ page import="java.util.List , tagdemo.student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<student> data = new ArrayList<>();
		data.add(new student("Sri","Ram"));
		data.add(new student("Arun","Ram"));
		data.add(new student("Naveen","Kumar"));
		data.add(new student("Vijay","Krishna"));
		pageContext.setAttribute("mystudents", data);
	%>
	
	<c:forEach var="st" items="${mystudents}">
		${st.firstname} ${st.lastname}
	</c:forEach>
</body>
</html>