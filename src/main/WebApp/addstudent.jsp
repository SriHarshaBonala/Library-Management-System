<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
	<h4 style="color: green;">Fill the form to register student to avail library services</h4>
	<form:form action="registerStudent" method="post" modelAttribute="register">
		<label style="color: red;">Student Id : </label> <input type="text" id="uid" name="uid"> <br><br>
		<label style="color: red;">Student Name : </label> <input type="text" id="name" name="name"> <br><br>
		<label style="color: red;">Student Email : </label> <input type="text" id="email" name="email"> <br><br>
		<label style="color: red;">Username : </label> <input type="text" id="username" name="username"> <br><br>
		<label style="color: red;">Password : </label> <input type="password" id="password" name="password"> <br><br>
		<label style="color: red;">Role : </label> <input readonly value="student"> <br><br>
		<input type="submit" style="width: 300px;  background-color: lightblue" value="Register Student">
	</form:form>
</body>
</html>