<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Expense Details</h1>
		<a href="/expenses">Go back</a>
	</div>
	<div>
		<h2>Expense Name: <c:out value="${expense.name}" /></h2>
		<h2>Expense Description: <c:out value="${expense.description}" /></h2>
		<h2>Vendor: <c:out value="${expense.vendor}" /></h2>
		<h2>Amount Spent: $<c:out value="${expense.amount}" /></h2>
	</div>
</body>
</html>