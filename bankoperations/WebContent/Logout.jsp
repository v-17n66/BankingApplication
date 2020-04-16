<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate();
%>
<h2 style='color:chocolate'>You are logged out successfully</h2>
<h2 style="color:green">Thanking You...</h2>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>