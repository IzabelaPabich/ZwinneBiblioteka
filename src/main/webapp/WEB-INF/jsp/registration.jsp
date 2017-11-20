<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutBeforeLogin>
    <form:form action="/registration" method="POST" modelAttribute="userForm">

        <form:input type="text" path="nazwauzy" placeholder="Nazwa"
                        autofocus="true"/>

        <form:input type="password" path="haslo" placeholder="Hasło"/>

        <form:input type="text" path="imiona_uzy" placeholder="Imię"/>
        <form:input type="text" path="nazwisko_uzy" placeholder="Nazwisko"/>
        <form:input type="text" path="pesel" placeholder="Pesel"/>
        <form:input type="text" path="email" placeholder="Adres email"/>
        <form:input type="text" path="telefon" placeholder="Numer telefonu"/>

        <form:button type="submit">Submit</form:button>

    </form:form>

    <c:if test="${userAlreadyExistsWarning ne null}">
        <c:out value="${userAlreadyExistsWarning}"/>
    </c:if>
</t:layoutBeforeLogin>