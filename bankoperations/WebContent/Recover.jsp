<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%@page import="mybeans.DBConnector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Recovering password...</h2>
<hr>
<%
String id,sq,an,nps,mo;
Connection con;
PreparedStatement pst;
ResultSet rs;

id=request.getParameter("uid");
sq=request.getParameter("sec");
an=request.getParameter("ans");

try
{
	DBConnector dbc=new DBConnector();
	con=dbc.getDbconnection();
	pst=con.prepareStatement("select * from userpersonal where useid=? and security_question=? and Answer=?;");
	pst.setString(1,id);
	pst.setString(2,sq);
	pst.setString(3,an);
	rs=pst.executeQuery();
	if(rs.next())
	{
		mo=rs.getString("mobile");
		nps=id.substring(1, 3)+"$"+mo.substring(3, 9);
		out.println("<h3 style='color:green'>Your new password is "+nps+"</h3>");
		
		pst=con.prepareStatement("update users set pswd=? where userid=?;");
		pst.setString(1,nps);
		pst.setString(2,id);
		pst.executeUpdate();
		
	}
	else
	{
		out.println("<h3 style='color:red'>User identity failed</h3>");
	}
	con.close();
}
catch(Exception e)
{
	out.println(e);
}

%>
<br>
<a href="index.jsp">Home</a>
</body>
</html>






