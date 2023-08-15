<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Edit Expense</h1>
		<a href="/expenses">Go back</a>
	</div>
	
	<form:form action="/expenses/edit/update/${expense.id}" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="patch">
    <div>
        <form:label path="name">Expense Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </div>
    <div>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </div>
    <div>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input path="amount"/>
    </div>
    <div>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:input path="description" />
    </div>    
    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>