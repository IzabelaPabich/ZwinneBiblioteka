<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="left-site menu-item">
    <a href="/mainpage">Strona główna</a>
</div>
<div class="left-site menu-item">
    <a href="/my_bookstore">Katalog książek</a>
</div>
<div class="left-site menu-item">
    <a href="/my_borrows">Moje wypożyczenia</a>
</div>
<div class="right-site menu-item">
    <form action="/logout" method="post">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input class="btn" type="submit" value="Wyloguj się">
    </form>
</div>