<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" action="/login" modelAttribute="userLoginForm">

    <form:input name="username" path="nazwauzy" type="text" placeholder="Podaj login"/>
    <form:input name="password" path="haslo" type="password" placeholder="Podaj haslo"/>

    <form:button type="submit">Zaloguj</form:button>

</form:form>