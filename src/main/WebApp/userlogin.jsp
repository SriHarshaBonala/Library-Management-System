<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Login</title>
</head>
<body>
	<h4 style="color: green;">Welcome Student!! Login to access the facilities</h4> <br><br>
	<form:form action="validateStudentLogin" method="post" modelAttribute="stulog">
		<label style="color: red;">Username : </label>
		<input type="text" id="username" name="username" placeholder="Enter Username"><br><br>
		
		<label style="color: red;">Password : </label>
		<input type="password" id="password" name="password" placeholder="Enter password"><br><br>
		
		<label style="color: red;"><b>${message}</b></label> <br><br>
		
		<input type="submit" style="width: 300px;  background-color: lightblue" value="Login">
	</form:form>
</body>
</html>