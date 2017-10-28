<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form method="POST" action="/login">

    <input name="username" type="text" />
    <input name="password" type="password"/>

    <button type="submit">Zaloguj</button>

</form>