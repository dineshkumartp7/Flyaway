<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>
 <form action="ChangePass" method="post">
   Admin Email Id : <input name="email" value="<%= session.getAttribute("email")%>" readonly="readonly">
    <br>
    <br>
	Set new Password : <input type="password" name="password" required="required">
	<br>
	<br>
	<button type="submit">Change Password</button>
    </form>
    <br>
    <br>
    <center>
    <button><a href="AdminHome.jsp" style="text-decoration:none;">GoTo HomePage</a></button>
</center>
</body>
</html>