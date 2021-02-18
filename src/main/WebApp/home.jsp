<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AIT Library</title>
</head>
<body>
	<h4 style="color: green;">Welcome to the AIT Library</h4>
	<h4 style="color: orange;">Please Login accordingly to access the facilities</h4>
	
	<form action="studentLogin"><button style="width: 300px;  background-color: lightblue">Student Login</button></form> <br><br>
	<form action="librarianLogin"><button style="width: 300px;  background-color: lightblue">Librarian Login</button></form> <br><br>
	<form action="/availablebooks"><button style="width: 300px;  background-color: lightblue">Check Book Availability</button></form><br><br>
	
	<label style="color: red;"><b>${message}</b></label> <br><br>
</body>
</html>