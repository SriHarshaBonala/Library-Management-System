<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books borrowed</title>
</head>
<body>
	<h4 style="color: green;">Hello, ${librarianname}. Below are the books currently borrowed by students along with their id.</h4>
	<table border="1">
		<tr style="color: orange;">
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Username</th>
			<th>Email</th>
			<th>Book Title</th>
			<th>Author1</th>
			<th>Author2</th>
			<th>Author3</th>
			<th>Edition</th>
		</tr>
		<c:forEach items="${borrowedBooks.rows}" var="borrowedbook">
		<tr style="color: red;">
			<td>${borrowedbook.uid}</td>
			<td>${borrowedbook.name}</td>
			<td>${borrowedbook.username}</td>
			<td>${borrowedbook.email}</td>
			<td>${borrowedbook.title}</td>
			<td>${borrowedbook.author1}</td>
			<td>${borrowedbook.author2}</td>
			<td>${borrowedbook.author3}</td>
			<td>${borrowedbook.edition}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>