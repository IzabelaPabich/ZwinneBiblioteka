<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<div id="menu">
    <div class="right-site menu-item">
        <form action="/logout" method="post">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <input class="btn" type="submit" value="Wyloguj się">
        </form>
    </div>
</div>

<script type="text/javascript">
    $('document').ready(getMenuItems());

    function getMenuItems() {
        $.get('/menu', function(data) {
            var menu = document.getElementById("menu");
            var menuHTML = '';
            $.map( data, function( val, i ) {
              menuHTML = menuHTML + '<div class="left-site menu-item"> <a href="' + val.key + '">' + val.name + '</a> </div>'
            });
            $(menu).append(menuHTML);
        });
    }
</script>