<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book</title>
</head>
<body>
	<h4 style="color: green;">Fill the form below and submit for book return confirmation</h4>
	<form:form action="returnBook" method="post" modelAttribute="return">
		<label style="color: red;">Student ID : </label> <input type="text" id="uid" name="uid"> <br><br>
		<label style="color: red;">Book ID : </label> <input type="text" id="bid" name="bid"><br><br>
		<label style="color: red;">Book Title : </label> <input type="text" id="title" name="title"><br><br>
		<input type="submit" style="width: 300px;  background-color: lightblue" value="Confirm Return">
	</form:form>
</body>
</html>