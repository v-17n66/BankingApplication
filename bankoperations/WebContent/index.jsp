<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap-min.css">
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<table>
<td width="299" valign="right">
    	<div id="welcome" style="border-right:#666666 1px dotted;"><br>
<img src=login.png>
<img src=images.jpg width="299" height="150">
<h2 style="color:green">Signature Bank Online Banking</h2>
<hr>
<form name="frm" method="post" action="Check">
<table>
<tr>
<td style="color:chocolate">UesrID
<td><input type="text" name="uid">
</tr>
<tr >
<td style="color:chocolate">Password
<td><input type="text" name="psw">
</tr>
<tr>
<td>
<td><input type="submit" value="LOGIN">
</tr>
</table>
</form>
<br>
<br>
<a href="CheckUser.html">New User?Create an Account</a>
<br>
<a href="RecoverPassword.html">Forgot password? Recover. </a>
<hr>
<br>
<br>
Powered by JavaEE on Eclipse
<br>
&copy;sohamglobal.com 2020 
</table>
</td>
</div>
</div>
</body>
</html>