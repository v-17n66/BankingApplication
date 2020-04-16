<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="top_links">

<div id="header">
	<h1> Internet Banking<span class="style1"></span></h1>
    <h2>ExtraOrdinary Service</h2>
    
       <h3>Manager Portal</h3>
    <a href="index.jsp">Home</a>
 <br>
    <a href="Logout.jsp" >Logout</a>
    <br>
    <%
String userid=String.valueOf(session.getAttribute("userid"));
%>
    Logged in as :<%=userid %>
<br>
Session ID : <%=session.getId() %>
<br>
<span id="demo"></span>
    	
</div>

<script>
var myVar = setInterval(myTimer, 1000);

function myTimer() {
    var d = new Date();
    dtm=d.toLocaleDateString()+" "+d.toLocaleTimeString()
    document.getElementById("demo").innerHTML = dtm;
}
</script>



<div id="navigation">
    <ul>
     <li><a href="openNewAccount.html">New Account</a></li>
    <li><a href="SearchAccount.html">Search Account</a></li>
    <li><a href="TransferManager.html">Transfer</a></li>
    <li><a href="transaction.html">withdraw/deposit</a></li>
     <li><a href="DailyTransReport.jsp">Daily Report</a></li>
    <li><a href="UserStatus.html">Activate/Deactivate</a></li>
    <li><a href="closeacc.html">Close A/C</a></li>
   
    </ul>
</div>


<table style="width:897px; background:#FFFFFF; margin:0 auto;"><tr align="justify">
	<td width="299" valign="top" style="border-right:#666666 1px dotted;">
    	<div id="services"><h1>Services</h1><br>
		    <ul>
        	<li><a href="#">www.onlineBank.com</a></li>
            <li><a href="#">www.onlinewebteck.com </a></li>
            <li><a href="#">www.sohamglobal.com</a></li>
            <li><img src="index9.jpg" alt="business" width="230" height="120"></li>
            </ul>
			
       </div>
	</td>
    
    <td width="299" valign="top">
    	<div id="welcome" style="border-right:#666666 1px dotted;"><h1>Welcome</h1><br>
    	    <center><img src="images3.jpg" alt="business" width="230" height="120"></center><br>
		    <p>Banking at your fingertips

Internet Banking offers you the ease and convenience of transacting in an environment you feel most comfortable with. You can check balances and transactions, transfer funds, pay bills, open fixed and recurring deposits and much more.
	    </div>      
    </td>
    
    <td width="65" valign="top">
   	  <div id="news"><h1>News &amp; Events</h1><br>
      	<div class="img"><img src="images5.jpg" alt="Business" width="65" height="55"></div>
        <h2>April. 12, 2020.</h2>
        <p>Internet Banking is a convenient way to do banking from the comfort of your home or office. Avoid the queue or delays and try our simple and secure Internet Banking facility for an unmatched online banking experience.</p><br>
        <div class="img"><img src="images6.jpg" alt="Business" width="65" height="55"></div>
        <h2>April. 12, 2020.</h2>
        <p>Industry-accepted security practices along with a multi-level authentication system has been put in place to authenticate your identity when you access your Internet Banking account. To know about security features of ICICI Bank Internet Banking, please click here.</p><br>
      
      </div>
        	
     </td>
</tr></table>

<div id="footer_top">
  <div id="footer_navigation">
  

  </div>
  
  <div id="footer_copyright" >
 
    	    <center><img  alt="business"  width="196" height="106"></center><br>
		    <p>Copyright ©Sohamglobal.com</div>
  
</div>

</div>

</body>
</html>