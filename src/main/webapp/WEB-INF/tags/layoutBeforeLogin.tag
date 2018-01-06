<%@tag description="Layout page" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="pl">
    <head>
        <meta charset="utf-8">
        <title>Biblioteka Zwinne</title>
        <meta name="description" content="Projekt na ZMZP">
        <meta name="author" content="Łukasz Baryczka, Piotr Bednarek, Jacek Wróblewski, Przemysław Staszyński, Izabela Pabich">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="/resources/css/layout.css">
    </head>
    <body>
        <!--
        <div>layoutBeforeLogin</div>
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
    <table>
        <tr>
            <td>anonymous</td>
            
        </tr>
    </table>
</sec:authorize>
        <sec:authorize access="hasRole('UZYTKOWNIK')">
    <table>
        <tr>
            <td>uzytkownik</td>
            
        </tr>
    </table>
</sec:authorize>
        <sec:authorize access="hasRole('MODERATOR')">
    <table>
        <tr>
            <td>moderator</td>
            
        </tr>
    </table>
</sec:authorize>
        -->
        <!-- Roles display 
<sec:authentication property="authorities" var="roles" scope="page" />
Your roles are:
<ul>
    <c:forEach var="role" items="${roles}">
    <li>${role}</li>
    </c:forEach>
</ul>
        -->
        <header class="header">
            <div class="logo">
                <jsp:include page="/WEB-INF/jsp/logo.jsp" />
            </div>

            <div class="menu">
                <jsp:include page="/WEB-INF/jsp/menuBeforeLogin.jsp" />
            </div>
        </header>

        <br>

        <div class="content">
            <section>
                <jsp:doBody/>
            </section>
        </div>
    </body>
</html>