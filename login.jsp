<%@page import="it.itsvita.byte19.ufc9.utils.Utils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ProjectFabioHong</title>
	</head>
	
	<body>
		<h2>Welcome <%= session.getAttribute(Utils.PARAM_USERNAME) %>!</h2>
		
		<p>Your password is: <%= session.getAttribute(Utils.PARAM_PASSWORD) %> </p>
		
		<p>
 			<% if(session.getAttribute(Utils.PARAM_LAST_LOGIN_NAME) != null) { %>
	  			<%-- Note: we can use expression here! --%>
	  			The last user was: <%= session.getAttribute(Utils.PARAM_LAST_LOGIN_NAME) %>
 			<% } %>
		</p>
	
		<a href='converter'>Web Converter</a><br><br>
	
		<form action="logout" method="POST">
			<input type="submit" value="Logout"/>
		</form>
	</body>
</html>