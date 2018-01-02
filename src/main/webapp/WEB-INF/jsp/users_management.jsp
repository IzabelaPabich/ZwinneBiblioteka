<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div>
        <table frame="border" border="1">
            <tr>
            <td>Nazwa Użytkowika</td>
            <td>Imiona</td>
            <td>Nazwisko</td>
            <td>Pesel</td>
            <td>Email</td>
            <td>Operacja</td>
            </tr>
        <c:forEach var="user" items="${users}" varStatus="counter">
            <tr>
            <td><c:out value="${user.nazwaUzy}"/></td>
            <td><c:out value="${user.imiona_uzy}"/></td>
            <td><c:out value="${user.nazwisko_uzy}"/></td>
            <td><c:out value="${user.pesel}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><form method="post" action="<c:out value="${delete_user}"/>"><input type="hidden" name="id" value="<c:out value="${user.id_uzytkownika}"/>"/><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><input type='submit' value='Usuń użytkownika'></form><br></td>
            </tr>
        </c:forEach>
        </table>
    </div>
</t:layoutAfterLogin>