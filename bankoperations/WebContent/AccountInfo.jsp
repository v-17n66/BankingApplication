<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
    <%@page import="mybeans.DBConnector" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%

String userid=String.valueOf(session.getAttribute("userid"));
String uid=request.getParameter(session.getId());
if(userid!=null)
{
%>

<h2 style='color:chocolate'>Accounts report</h2>
<hr>
<table width="450px" border="1" cellspacing="0" bordercolor="silver">
<tr style="background-color:seashell">
<th>Account Number
<th>Name
<th>Type
<th>Balance
<th>Open Date
</tr>
<%
Connection con;
PreparedStatement pst;
ResultSet rs;

try
{
	DBConnector dbc=new DBConnector();
	con=dbc.getDbconnection();
	pst=con.prepareStatement("select * from accounts where accno=?;");
	pst.setString(1, userid);
	rs=pst.executeQuery();
	while(rs.next())
	{
		%>
	<tr>
	<td><%=rs.getString("accno") %>
	<td><%=rs.getString("accnm") %>
	<td><%=rs.getString("acctype") %>
	<td><%=rs.getString("balance") %>
	<td><%=rs.getDate("opendate") %>
	</tr>	
		<%
	}
	con.close();
}
catch(Exception e)
{
	out.println(e);
}
%>
</table>
<br>
<br>
<a href="customer.jsp">Back</a>
<%
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