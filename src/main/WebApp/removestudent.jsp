<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Cancellation</title>
</head>
<body>
	<h4 style="color: green;">Fill the form to remove student to cancel all library services</h4>
	<form:form action="removeStudent" method="post" modelAttribute="remove">
		<label style="color: red;">Student Id : </label> <input type="text" id="uid" name="uid"> <br><br>
		<label style="color: red;">Student Name : </label> <input type="text" id="name" name="name"> <br><br>
		<input type="submit" style="width: 300px;  background-color: lightblue" value="Unregister Student">
	</form:form>
</body>
</html>