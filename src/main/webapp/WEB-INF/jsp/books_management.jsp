<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div>
        <table frame="border" border="1">
            <tr>
            <td>Tytuł książki</td>
            <td>Nazwisko autora</td>
            <td>Imiona autora</td>
            <td>Data wydania</td>
            <td>Operacja</td>
            </tr>
        <c:forEach var="book" items="${books}" varStatus="counter">
            <tr>
            <td><c:out value="${book.nazwa_ksiazki}"/></td>
            <td><c:out value="${book.nazwisko_autora}"/></td>
            <td><c:out value="${book.imiona_autora}"/></td>
            <td><c:out value="${book.data_wydania}"/></td>
            <td><form method="post" action="<c:out value="${delete_book}"/>"><input type="hidden" name="id" value="<c:out value="${book.id_ksiazki}"/>"/><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><input type='submit' value='Usuń książkę'></form><br></td>
            </tr>
        </c:forEach>
        </table>
    </div>
</t:layoutAfterLogin>