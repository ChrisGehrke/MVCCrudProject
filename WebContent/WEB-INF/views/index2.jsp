<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wine Selections</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<style>
body{background-image: url("file:///Users/chrisgehrke/SD/Java/stsworkspace/MVCProject/WebContent/images/WineCountryBackground.jpg");
  height: 100%;
 background-position: right;
    background-repeat: no-repeat;
    background-size: cover;
}
}

</style>
</head>
<body>
	<h2>Welcome to Wine Country</h2>

	<form:form action="getWine.do" method="post" modelAttribute="idForm">
		<form:input path="id" />
		<form:errors path="id" />


		<input type="submit" value="Get a Wine">
	</form:form>
<p>
All Wines: <br>
<c:forEach var="vine" items="${list }">

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
</p>



<p>
<a href="add.do">Add a Wine</a>
</p>

</body>
</html>