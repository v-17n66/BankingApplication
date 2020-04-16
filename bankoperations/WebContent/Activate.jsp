 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="mybeans.DBConnector" %>
    <%@page import="java.sql.* "%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String userid=String.valueOf(session.getAttribute("userid")); %>

<% String act = request.getParameter("acno");
String status=request.getParameter("ust");
%>


<%

DBConnector db= new DBConnector();
Connection con=db.getDbconnection();

PreparedStatement pst;
if(userid!=null)
{
try{
	
      pst=con.prepareStatement("update users set userstatus=? where userid=?;");
      pst.setString(1,status);
      pst.setString(2, act);
      pst.executeUpdate();
      if(status.equals("active"))
      {
    	  out.println("<br>");
    	  out.println("<h2>Status</h2>");
    	  
    	  out.println("<hr>");
    	  out.println("<br>");
      out.println("<h2  style='color:green'>User Account activate successfully</h2>");
      out.println("<br>");
      out.println("<a href='manager.jsp'>Back</a>");

      }
      else
      {
    	  out.println("<br>");
      out.println("<h2>Status</h2>");
	  
	  out.println("<hr>");
	  out.println("<br>");
      out.println("<h2  style='color:green'>User Account Deactivate successfully</h2>");
      out.println("<br>");
      out.println("<a href='manager.jsp'>Back</a>");

      }
}
catch(Exception e)
{
	out.print(e);
}
}
else
{
%>
<h3 style="color:red">invalid session...</h3>
<a href="index.jsp">Login Now</a>
<%
}
%>
</body>
</html>