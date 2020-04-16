<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="mybeans.TransAmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:chocolate">Recharge Status</h3>
<hr>
<br>
<%  
     String mob;
     int op;
     double amt;
     String userid=String.valueOf(session.getAttribute("userid"));
     mob=request.getParameter("mn");
     op=Integer.parseInt(request.getParameter("op"));
    
     
     int sacc,dacc;
		
		
		sacc=Integer.parseInt(userid );
		dacc=op;
		amt=Double.parseDouble(request.getParameter("amt"));
		
		TransAmt tm=new TransAmt();
		tm.setSourceacc(sacc);
		tm.setDestinationacc(dacc);
		tm.setAmount(amt);
		
		 if(tm.isTransferstatus())
				out.println("<h3 style='color:green'>Dear Customer Your Recharge is  Successfull</h3>");
			else
				out.println("<h3 style='color:red'>Payment Failed...</h3>");
			 %>
		<br>
		<a href="Recharge.html">Back</a>
		<br>
		<a href="customer.jsp">Home</a>
		<br>
		<a href="AccountStatement.jsp">Check Balance</a>
</body>
</html>