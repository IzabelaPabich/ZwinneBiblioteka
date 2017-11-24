<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div>
        <c:forEach var="book" items="${books}" varStatus="counter">
            <c:out value="${book.nazwa_ksiazki}"/><form method="post" action="<c:out value="${action}"/>"><input type="hidden" name="id" value="<c:out value="${book.id_ksiazki}"/>"/><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><input type='submit' value='Zwróć'></form><br>
        </c:forEach>
    </div>
</t:layoutAfterLogin>