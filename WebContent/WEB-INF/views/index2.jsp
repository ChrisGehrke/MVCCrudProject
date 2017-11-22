<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wine Selections</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>
	<h1 id="MainHeader">Welcome to Wine Country</h1>

	<form:form action="getWine.do" method="post" modelAttribute="idForm">
		<form:input path="id" />
		<form:errors path="id" />


		<input type="submit" value="Get a Wine">
	</form:form>
	
<h3 id="allWines">All Wines: </h3><br>
<c:forEach var="vine" items="${list }">
<img id="img2" alt="${vine.name} bottle" src="images/${vine.imageName}">
<a href="info.do?id=${vine.id }">${vine.name }</a>

<form method="post" action="update.do">
	<input type="submit" value="Update" >
	<input type="hidden" name="id" value="${vine.id }">
</form>
<form method="post" action="delete.do">
	<input type="submit" value="Delete" >
	<input type="hidden" name="id" value="${vine.id }">
</form>
<br>
</c:forEach>



<p>
<a href="add.do">Add a Wine</a>
</p>

</body>
</html>