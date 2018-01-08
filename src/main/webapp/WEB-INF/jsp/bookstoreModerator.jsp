<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div>
        <form method="post" action="<c:out value="${action}"/>">
        <div><input type="text" name="search_text" placeholder="Search.."><button class="btn item" type="submit">Szukaj</button></div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <table class="table" frame="border" border="1">
            <tr class="darkLine">
                <th>Autor</th>
                <th>Tytuł</th>
                <th>Rok wydania</th>
                <th>Czy dostępna</th>
            </tr>
        <c:forEach var="book" items="${books}" varStatus="counter">
            <tr class="whiteLine">
                <td><c:out value="${book.imiona_autora}"/>&nbsp;<c:out value="${book.nazwisko_autora}"/></td>
            <td><c:out value="${book.nazwa_ksiazki}"/></td>
            <td><fmt:formatDate type = "date" pattern="Y" value = "${book.data_wydania}" /></td>
            <td><c:if test="${book.getDostepna() eq false}"> nie</c:if><c:if test="${book.getDostepna()}"> tak</c:if></td>
            </tr>
        </c:forEach>
        </table>
    </div>
</t:layoutAfterLogin>
