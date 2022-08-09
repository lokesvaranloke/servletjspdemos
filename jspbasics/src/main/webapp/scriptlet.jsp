<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>For Loop</h2>
	<%
		for(int i=1;i<=5;i++){
			out.println("Welcome "+i);
		}
	%>	
	
	
	
	<jsp:include page="footer.jsp" />
</body>
</html>