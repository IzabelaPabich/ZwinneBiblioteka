<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div>
        <table>
            <tr>
                <th>Autor</th>
                <th>Tytuł</th>
                <!--<th>Użytkownik</th>-->
                <th>Akcja</th>
            </tr>
        <c:forEach var="book" items="${books}" varStatus="counter">
            <tr>
                <td><c:out value="${book.imiona_autora}"/>&nbsp;<c:out value="${book.nazwisko_autora}"/></td>
                <td><c:out value="${book.nazwa_ksiazki}"/></td>
                <!--<td><c:if test="${book.getDostepna() eq false}"><c:out value="${book.holder.imiona_uzy}"/>&nbsp;<c:out value="${book.holder.nazwisko_uzy}"/></c:if></td>-->
                <td>
                    <c:if test="${book.getDostepna() eq false}">
                    <form method="post" action="<c:out value="${action}"/>"><input type="hidden" name="id" value="<c:out value="${book.id_ksiazki}"/>"/><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><input type='submit' value='Zwróć'></form>
                    </c:if>
                    <c:if test="${book.getDostepna()}">
                    <form method="get" action="/book/<c:out value="${book.id_ksiazki}"/>">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type='submit' value='Wypożycz'>
                    </form>
                    </c:if>
                    </td>
            </tr>
            
        </c:forEach>
        </table>
    </div>
</t:layoutAfterLogin>