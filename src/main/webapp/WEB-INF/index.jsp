<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Save Travels</h1>
<table>
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <!-- loop over all the books to show the details as in the wireframe! -->
        <c:forEach var="expense" items="${expenses}">
        	<tr>
         	<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}" /></a></td>
         	<td><c:out value="${expense.vendor}" /></td>
         	<td>$<c:out value="${expense.amount}" /></td>
         	<td>
         		<a href="/expenses/edit/${expense.id}">edit</a>
         		<form action="/expenses/delete/${expense.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete">
				</form>
         	</td>
        	</tr>
        </c:forEach>
    </tbody>
</table>
<div>
	<h2>Add an Expense:</h2>
	<form:form action="/expenses/create" method="post" modelAttribute="expense">
		<p>
			<form:errors path="name"/>
			<form:errors path="vendor"/>
			<form:errors path="amount"/>
			<form:errors path="description"/>
		</p>
		<p>
			<form:label path="name">Expense Name</form:label>
	        
	        <form:input path="name"/>
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>
	        
	        <form:input path="vendor"/>
		</p>
		<p>
			<form:label path="amount">Amount</form:label>
	        
	        <form:input path="amount"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
	        
	        <form:input path="description"/>
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</div>
</body>
</html>