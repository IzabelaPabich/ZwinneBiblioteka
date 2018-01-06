<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutBeforeLogin>
    <div>
        <h1>Witaj na stronie głównej biblioteki</h1>
        <h3>Po zalogowaniu możesz:</h3>
        <ul>
            <li>sprawdzić wypożyczone książki</li>
            <li>sprawdzić aktualnie możliwe do wypożyczenia pozycje</li>
            <li>wypożyczyć książkę</li>
            <li>oddać książkę</li>
        </ul>
    </div>
</t:layoutBeforeLogin>