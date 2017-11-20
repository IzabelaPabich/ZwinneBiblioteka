<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav>
    <div>
        <ul>
            <li>
                <a href="mainpage">Strona główna</a>
            </li>
            <li>
                <a href="bookstore">Katalog książek</a>
            </li>
            <li>
                <a href="borrows">Moje wypożyczenia</a>
            </li>
            <li>
                <form action="/logout" method="post">
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                    <input type="submit" value="Wyloguj się">
                </form>
            </li>
        </ul>
    </div>
</nav>