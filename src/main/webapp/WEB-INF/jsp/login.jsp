<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutBeforeLogin>
    <div class="login whiteLine">
        <div class="login-text darkLine">
            Zaloguj się
        </div>
        <div class="login-form">
            <form action="/login" method="post">
                <c:if test="${param.error != null}">
                    <p style='color:red'>
                        Invalid username and password.
                    </p>
                </c:if>
                <c:if test="${param.logout != null}">
                    <p style='color:blue'>
                        You have been logged out.
                    </p>
                </c:if>
                <p>
                    <label for="username">Nazwa użytkownika</label>
                    <input type="text" id="username" name="username"/>
                </p>
                <p>
                    <label for="password">Hasło</label>
                    <input type="password" id="password" name="password"/>
                </p>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <input class="btn item background" type="submit" value="Zaloguj się"/>

            </form>
        </div>
    </div>
</t:layoutBeforeLogin>