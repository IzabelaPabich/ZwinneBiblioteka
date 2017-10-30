<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
Hello ${name}

<c:forEach var="user" items="${users}" varStatus="counter">
    <c:out value="${user.id_uzytkownika}"/><br>
    <c:out value="${user.nazwaUzy}"/><br><br>
</c:forEach>

<c:forEach var="book" items="${books}" varStatus="counter">
    <c:out value="${book.nazwa_ksiazki}"/><br>
</c:forEach>


</body>
</html>