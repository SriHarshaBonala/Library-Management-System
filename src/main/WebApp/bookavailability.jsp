<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Availability</title>
</head>
<body>
	<!--<sql:setDataSource
        var="database"
        url="jdbc:postgresql://localhost:5432/librarysystem"
        user="postgres" password="16011M3513"/>
	
	<sql:query var="availableBooks" dataSource="${database}">
		SELECT * FROM book;
	</sql:query>
	-->
	<h4 style="color: green;">Check the list of current availability of books in the library</h4>
	<table border="1">
		<tr style="color: orange;">
			<th>BookId</th>
			<th>Title</th>
			<th>Author1</th>
			<th>Author2</th>
			<th>Author3</th>
			<th>Edition</th>
			<th>Available Copies</th>
		</tr>
		<c:forEach items="${availableBooks.rows}" var="availbook">
		<tr style="color: red;">
			<td style="text-align: center;">${availbook.bid}</td>
			<td style="text-align: center;">${availbook.title}</td>
			<td style="text-align: center;">${availbook.author1}</td>
			<td style="text-align: center;">${availbook.author2}</td>
			<td style="text-align: center;">${availbook.author3}</td>
			<td style="text-align: center;">${availbook.edition}</td>
			<td style="text-align: center;">${availbook.copies_available}</td>
		</tr>
		</c:forEach>
	</table>
	<form action="logout_student"><button>Return to home page</button></form>
</body>
</html>