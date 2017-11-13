<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Wine Data</title>
</head>
<body>
<h3>Enter data about your wine</h3>
	<form:form action="updateWine.do" method="post" modelAttribute="wine">
	Name: <form:input path="name"/><form:errors path="name"/><br>
	Bottle Size: <form:input path="bottlesize"/><form:errors path="bottlesize"/><br>
	ABV: <form:input path="abv"/><form:errors path="abv"/><br>
	Price: <form:input path="price"/><form:errors path="price"/><br>
	<form:hidden path="id"/>
	<input type="submit" value="Update">
	</form:form>	
	
	
</body>
</html>