<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="left-site menu-item">
    <a href="/mainpage">Strona główna</a>
</div>
<div class="left-site menu-item">
    <a href="/users_management">Zarządzaj użytkownikami</a>
</div>
<div class="left-site menu-item">
    <a href="/books_management">Zarządzaj książkami</a>
</div>
<form action="/logout" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input class="btn menu-item right-site background" type="submit" value="Wyloguj się">
</form>