<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div>
        <table>
            <tr>
                <th>Tytuł</th>
                <th>Autor</th>
                <th>Kiedy wypożyczona</th>
            </tr>
        <c:forEach var="book" items="${books}" varStatus="counter">
            <tr>
                <td><c:out value="${book.ksiazka.nazwa_ksiazki}"/></td>
                <td><c:out value="${book.ksiazka.imiona_autora}"/>&nbsp;<c:out value="${book.ksiazka.nazwisko_autora}"/></td>
                <td><fmt:formatDate type = "both" dateStyle = "medium" timeStyle = "medium" value = "${book.data_wypozyczenia}" /></td>
            </tr>
        </c:forEach>
        </table>
    </div>
</t:layoutAfterLogin>