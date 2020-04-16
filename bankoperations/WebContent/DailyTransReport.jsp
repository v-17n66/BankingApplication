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
 <%
if(session.getAttribute("userid")!=null)
{
%>

<h2 style=color:chocolate>Accounts report</h2>
<hr>
<table width="450px" border="1" cellspacing="0" bordercolor="silver">
<tr style="background-color:seashell">
<th>Transaction Number
<th>Transaction Date
<th>Account Number
<th>Transaction Type
<th>Amount
</tr>
<%
Connection con;
PreparedStatement pst;
ResultSet rs;

try
{
	DBConnector db= new DBConnector();
	con=db.getDbconnection();
	pst=con.prepareStatement("select * from acctransaction where transdt=cast(curdate()as Date);");
	rs=pst.executeQuery();
	
	
	
	while(rs.next())
	{
		
		%>
	<tr>
	<td><%=rs.getString("transno") %>
	<td><%=rs.getString("transdt") %>
	<td><%=rs.getString("accno") %>
	<td><%=rs.getString("transactiontype") %>
	<td><%=rs.getString("amount") %>
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
<%
out.println("<br>");
out.println("<a href='manager.jsp'>Back</a>");

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