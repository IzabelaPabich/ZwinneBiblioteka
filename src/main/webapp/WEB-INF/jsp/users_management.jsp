<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div class="container">
        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#newUserModal">Dodaj użytkownika</button>

        <!-- Modal -->
        <div class="modal fade" id="newUserModal" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Dodaj nowego użytkownika</h4>
                    </div>
                    <form:form id="new" role="form" class="form-horizontal" action="/add_user" method="POST" modelAttribute="userRegistrationForm">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="nazwauzy">Nazwa użytkownika</label>
                                <form:input type="text" class="form-control" path="nazwauzy"
                                            id="nazwauzy" placeholder="Podaj nazwę dla użytkownika" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="haslo">Hasło użytkownika</label>
                                <form:input type="password" class="form-control" path="haslo"
                                            id="haslo" placeholder="Podaj hasło dla użytkownika" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="imiona_uzy">Imiona użytkownika</label>
                                <form:input type="text" class="form-control" path="imiona_uzy"
                                            id="imiona_uzy" placeholder="Podaj imiona użytkownika" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="nazwisko_uzy">Nazwisko użytkownika</label>
                                <form:input type="text" class="form-control" path="nazwisko_uzy"
                                            id="nazwisko_uzy" placeholder="Podaj nazwisko użytkownika" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="pesel">Pesel użytkownika</label>
                                <form:input type="text" class="form-control" path="pesel" pattern="[0-9]{11}"
                                            id="pesel" placeholder="Podaj pesel użytkownika" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="email">Email użytkownika</label>
                                <form:input type="email" class="form-control" path="email"
                                            id="email" placeholder="Podaj email użytkownika" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="telefon">Telefon użytkownika</label>
                                <form:input type="text" class="form-control" path="telefon" pattern="[1-9][0-9]{8}"
                                            id="telefon" placeholder="Podaj telefon użytkownika" required="required" />
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </div>
                        <div class="modal-footer">
                            <form:button type="submit" class="btn btn-primary">Zapisz</form:button>
                            <form:button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</form:button>
                        </div>
                    </form:form>
                    <c:if test="${userAlreadyExistsWarning ne null}">
                        <c:out value="${userAlreadyExistsWarning}"/>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <div>
        <table frame="border" border="1">
            <tr>
            <td>Nazwa Użytkowika</td>
            <td>Imiona</td>
            <td>Nazwisko</td>
            <td>Pesel</td>
            <td>Email</td>
            <td>Operacja</td>
            </tr>
        <c:forEach var="user" items="${users}" varStatus="counter">
            <tr>
            <td><c:out value="${user.nazwaUzy}"/></td>
            <td><c:out value="${user.imiona_uzy}"/></td>
            <td><c:out value="${user.nazwisko_uzy}"/></td>
            <td><c:out value="${user.pesel}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><form method="post" action="<c:out value="${delete_user}"/>"><input type="hidden" name="id" value="<c:out value="${user.id_uzytkownika}"/>"/><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><input type='submit' value='Usuń użytkownika'></form><br></td>
            </tr>
        </c:forEach>
        </table>
    </div>
</t:layoutAfterLogin>