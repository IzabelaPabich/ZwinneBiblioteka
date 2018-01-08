<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div>
        <table class="table" frame="border" border="1">
            <tr class="darkLine">
                <th>Autor</th>
                <th>Tytuł</th>
                <th>Rok wydania</th>
                <th>Czy dostępna</th>
            </tr>
            <tr class="whiteLine">
                <td><c:out value="${book.imiona_autora}"/>&nbsp;<c:out value="${book.nazwisko_autora}"/></td>
                <td><c:out value="${book.nazwa_ksiazki}"/></td>
                <td><fmt:formatDate type = "date" pattern="Y" value = "${book.data_wydania}" /></td>
                <td><c:if test="${book.getDostepna() eq false}"> nie</c:if><c:if test="${book.getDostepna()}"> tak</c:if></td>
            </tr>
            
        </table>
            <c:if test="${book.getDostepna()}">
        <form method="post" action="<c:out value="${action_user}"/>">
        <table class="table" frame="border" border="1">
            <tr class="darkLine">
                <th>Użytkownik</th>
            </tr>
            <c:forEach var="user" items="${users}" varStatus="counter">
                <tr class="whiteLine">
                    <td>
                        <label>
                        <input type="radio" name="user" value="<c:out value="${user.id_uzytkownika}"/>">
                        <c:out value="${user.imiona_uzy}"/>&nbsp;<c:out value="${user.nazwisko_uzy}"/>
                        </label>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <button class="btn item" type="submit">Wypożycz</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        </c:if>
            <c:if test="${book.getDostepna() eq false}">
                <p>Książka chwilowo niedostępna, wypożyczona przez: <b><c:out value="${bookBorrow.uzytkownik.imiona_uzy}"/>&nbsp;<c:out value="${bookBorrow.uzytkownik.nazwisko_uzy}"/></b></p>
                </c:if>
    </div>
</t:layoutAfterLogin>
