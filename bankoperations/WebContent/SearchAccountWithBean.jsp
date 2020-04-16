<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="mybeans.SearchAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:brown">Account Information</h2>
<hr>
<%
int no=Integer.parseInt(request.getParameter("ano"));
SearchAccount sa=new SearchAccount();
sa.setAcnumber(no);
%>
Account Name: <%=sa.getAcname() %>
<br>
Balance:  <%=sa.getBalance() %>
<br>
<br>
<br>
<a href="SearchAccount.html">Back</a>
</body>
</html>