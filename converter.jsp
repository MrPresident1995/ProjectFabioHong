<%@page import="it.itsvita.byte19.ufc9.utils.Utils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ProjectFabioHong</title>
	</head>
	
	<body>
		<h2>Converter</h2>
	
		<form action="converter" method="POST">
            <input type="radio" id="ms_to_kmh" name="conversion" value="ms_to_kmh">
            <label for="ms_to_kmh">M/s -> Km/h</label><br>
            <input type="radio" id="kmh_to_ms" name="conversion" value="kmh_to_ms">
            <label for="kmh_to_ms">Km/h -> M/s</label><br><br>
            
            <input type="radio" id="mt_to_ms" name="conversion" value="mt_to_ms">
            <label for="ms_to_kmh">Meter -> Miles</label><br>
            <input type="radio" id="ms_to_mt" name="conversion" value="ms_to_mt">
            <label for="kmh_to_ms">Miles -> Meters</label><br><br>
            
            Value: <input type="number" name="value"><br><br>
            <input type="submit" value="Convert"><br>
    	</form>
    	
    	<% if(request.getAttribute("result") != null) { %>
			 <p style="color:Red">The result is <%= request.getAttribute(Utils.PARAM_RESULT) %> </p>
		<% } %>
		
		<form action="logout" method="POST">
			<input type="submit" value="Logout"/>
		</form>
	</body>
</html>