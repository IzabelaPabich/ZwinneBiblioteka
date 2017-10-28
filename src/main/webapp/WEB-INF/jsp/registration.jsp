<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="/registration" method="POST" modelAttribute="userForm">

    <input type="text" path="username" class="form-control" placeholder="Username"
                    autofocus="true"/>

    <input type="password" path="password" class="form-control" placeholder="Password"/>

    <button type="submit">Submit</button>

</form>
