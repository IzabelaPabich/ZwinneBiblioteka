<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div>
        <c:forEach var="book" items="${books}" varStatus="counter">
            <c:out value="${book.nazwa_ksiazki}"/><br>
        </c:forEach>
    </div>
</t:layoutAfterLogin>