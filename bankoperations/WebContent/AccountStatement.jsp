<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="mybeans.AccountStatement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:chocolate">Account Statement</h2>
<hr>
<%
String userid=String.valueOf(session.getAttribute("userid"));

AccountStatement sa=new AccountStatement();
sa.setAcno(Integer.parseInt(userid));
%>
<h2 style="color:green">Dear  Bank user your current account balance is <%=sa.getBalance() %></h2>
<br>
<br>
<br>
<a href="customer.jsp">Back</a>
</body>
</html>