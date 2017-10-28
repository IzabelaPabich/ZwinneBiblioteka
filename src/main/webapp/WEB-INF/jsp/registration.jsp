<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="/registration" method="POST" modelAttribute="userForm">

    <input type="text" path="nazwa_uzy" placeholder="Nazwa"
                    autofocus="true"/>

    <input type="password" path="haslo" placeholder="Hasło"/>

    <input type="text" path="imiona_uzy" placeholder="Imię"/>
    <input type="text" path="nazwisko_uzy" placeholder="Nazwisko"/>
    <input type="text" path="pesel" placeholder="Pesel"/>
    <input type="text" path="email" placeholder="Adres email"/>
    <input type="text" path="telefon" placeholder="Numer telefonu"/>

    <button type="submit">Submit</button>

</form>