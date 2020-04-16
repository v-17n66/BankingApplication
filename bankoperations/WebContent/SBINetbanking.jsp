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
<h2>SBI Netbanking</h2>
<hr>
<%
String userid=String.valueOf(session.getAttribute("userid"));
double amt=Double.parseDouble(request.getParameter("payamount"));

int sacc,dacc;
		
		
		sacc=Integer.parseInt(userid );
		dacc=1009;
		amt=Double.parseDouble(request.getParameter("payamount"));
		
		TransAmt tm=new TransAmt();
		tm.setSourceacc(sacc);
		tm.setDestinationacc(dacc);
		tm.setAmount(amt);
		
		
		 if(tm.isTransferstatus())
		 {
			out.println("<h3 style='color:chocolate'>Payment Successfully</h3>");
		    out.println("<a href='customer.jsp'>Back</a>");
		    out.println("<br>");
		    out.println("<a href='AccountStatement.jsp'>Check Balance</a>");
		 }
		else
		{
			out.println("<h3 style='color:red'>Payment Failed...</h3>");
		 out.println("<a href='customer.jsp'>Back</a>");
		}
		 %>

</body>
</html>