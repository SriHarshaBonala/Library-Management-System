<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Home</title>
</head>
<body>
	<form action="logout_librarian"><input type="submit" style="width: 100px; background-color: lightblue" value="Logout"></form>
	<h2 style="color: green">Welcome ${librarianname}</h2>
	<h4 style="color: orange">Below are the facilities provided</h4>
	<form action="/studentborrowedbooks"><input type="submit" style="width: 300px;  background-color: lightblue" value="Check Books Borrowed by students"></form> <br>
	<form action="/listavailablebooks"><input type="submit" style="width: 300px;  background-color: lightblue" value="List all Books Availability"></form> <br>
	<button style="width: 300px;  background-color: lightblue" onclick="location.href='issuebook.jsp'">Issue Book</button> <br><br>
	<button style="width: 300px;  background-color: lightblue" onclick="location.href='returnbook.jsp'">Return Book</button> <br><br>
	<button style="width: 300px;  background-color: lightblue" onclick="location.href='addstudent.jsp'">Register Student</button> <br><br>
	<button style="width: 300px;  background-color: lightblue" onclick="location.href='removestudent.jsp'">Remove Student</button> <br><br>
</body>
</html>