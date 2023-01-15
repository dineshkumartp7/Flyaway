<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<style>
body{
margin : 0;
padding : 0;
}
.head{
background-color : #000;
color : #fff;
height : 50px;
}
h1{
font-family : "Times New Roman", Times, serif;
}
.login-box{
	margin-top : 40px;
	width : 500px;
	border : 1px solid #ccc;
	box-shadow : 0 8px 12px 0px rgba(0,0,0,0.3);
	positive : absolute;
}
input{
  	padding: 5px 10px;
  	margin: 8px 0;
  	display: inline-block;
  	border: 2px solid #ccc;
  	border-radius: 4px;
  	box-sizing: border-box;
}
button{
  	border-radius: 4px; 
	border:none;
	height: 30px;
	display : inline-block;
	font-size : 15px;
	background-color: rgb(0, 255, 128);
	margin : 5px;
}

</style>
</head>
<body>
<center>
<div class="head">
	<h1>FlyAway</h1>
</div>


	<%
	String flightn = request.getParameter("flightno");
        session.setAttribute("flightno", flightn);
	%>
<div class="login-box">	
<div>
<h2><u>Login Here</u></h2>
</div>
	<form action="loginServlet" method="post">
		<label><b>Enter username : </b></label><br/>
		<input type="email" name="email" required="required"><br>
		<label><b>Enter password : </b></label><br/>
		<input type="password" name="password"
			required="required"><br>
		<button type="submit"><b>Submit</b></button>
		<br>
		<p>
			New User? <a href="register.html?flightno=<% session.setAttribute("flightno",flightn);%>">Register here</a>
		</p>
	</form>
</div>
</center>
</body>
</html>