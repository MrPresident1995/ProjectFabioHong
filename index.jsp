<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ProjectFabioHong</title>
	</head>
	
	<body>
		<h2>Welcome</h2>
		
		<form action="login" method="POST">
			<input type="text" name="username" placeholder="Username"/><br><br>
			<input type="password" name="password" placeholder="Password"/><br><br>
			<input type="submit" value="Login"/>
		</form>
		
		<br><br>
		
	    <% if(request.getAttribute("wrongPassword") != null) { %>
			 <p style="color:Red">Your password is wrong or empty, please retry!</p>
		<% } %>
	</body>
</html>