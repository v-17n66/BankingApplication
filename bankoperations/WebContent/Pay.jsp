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
double amt;
String opt;
amt=Double.parseDouble(request.getParameter("amt"));
opt=request.getParameter("payopt");

if(opt.equals("netbanking"))
{
%>
<jsp:forward page="SBINetbanking.jsp">
<jsp:param name="payamount" value="<%=amt %>"/>
</jsp:forward>
<%
}
else
{
%>
<jsp:forward page="VisaCreditCard.jsp">
<jsp:param name="payamount" value="<%=amt %>"/>
</jsp:forward>

<%
}
%>
</body>
</html>









