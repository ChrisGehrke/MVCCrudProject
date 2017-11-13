<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wine Selections</title>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
<h2>Welcome to wine country</h2>

<form action="getWine.do" method="post">
<input type="number" name="wineId">
<input type="submit" value="Pick a Wine">
</form>

<c:if test="${not empty bestWine}">
The best wine is: ${bestWine}
</c:if>

</body>
</html>