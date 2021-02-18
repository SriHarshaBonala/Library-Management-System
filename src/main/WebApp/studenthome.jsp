<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home</title>
</head>
<body>
	<form action="logout_student"><input type="submit" style="width: 100px;  background-color: lightblue" value="Logout"></form>
	<h2 style="color: green;">Welcome ${studentname}</h2>
	<h4 style="color: orange;">Below are the facilities provided</h4>
	<form action="/borrowedbooks"><input type="submit" style="width: 300px;  background-color: lightblue" value="Check Books Borrowed"></form> <br><br>
	<form action="/availablebooks"><input type="submit" style="width: 300px;  background-color: lightblue" value="Check Books Availability"></form> <br><br>
</body>
</html>