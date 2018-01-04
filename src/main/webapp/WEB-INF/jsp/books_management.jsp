<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layoutAfterLogin>
    <div class="container">
        <!-- Trigger the modal with a button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#newBookModal">Dodaj książkę</button>

        <!-- Modal -->
        <div class="modal fade" id="newBookModal" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Dodaj nową książkę</h4>
                    </div>
                    <form:form id="new" role="form" class="form-horizontal" action="/add_book" method="POST" modelAttribute="newBookForm">
                    <div class="modal-body">
                            <div class="form-group">
                                <label for="nazwisko_autora">Nazwisko autora</label>
                                <form:input type="text" class="form-control" path="nazwisko_autora"
                                       id="nazwisko_autora" placeholder="Podaj nazwisko autora" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="imiona_autora">Imiona autora</label>
                                <form:input type="text" class="form-control" path="imiona_autora"
                                            id="imiona_autora" placeholder="Podaj imiona autora" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="tytul">Tytuł</label>
                                <form:input type="text" class="form-control" path="nazwa_ksiazki"
                                       id="tytul" placeholder="Podaj tytuł" required="required" />
                            </div>
                            <div class="form-group">
                                <label for="data_wydania">Data wydania</label>
                                <form:input type="date" class="form-control" path="data_wydania"
                                       id="data_wydania" placeholder="Podaj datę wydania" required="required" max="2100-12-31"/>
                            </div>
                            <div class="form-group">
                                <label for="kategoria">Kategoria:</label>
                                <form:select class="form-control" id="kategoria" path="kategoria">
                                    <option>Thriller</option>
                                    <option>Poradnik</option>
                                    <option>Dramat</option>
                                    <option>Naukowa</option>
                                    <option>Komedia</option>
                                </form:select>
                            </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </div>
                    <div class="modal-footer">
                        <form:button type="submit" class="btn btn-primary">Zapisz</form:button>
                        <form:button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</form:button>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <div>
        <table frame="border" border="1">
            <tr>
            <td>Tytuł książki</td>
            <td>Nazwisko autora</td>
            <td>Imiona autora</td>
            <td>Data wydania</td>
            <td>Kategoria</td>
            <td>Operacja</td>
            </tr>
        <c:forEach var="book" items="${books}" varStatus="counter">
            <tr>
            <td><c:out value="${book.nazwa_ksiazki}"/></td>
            <td><c:out value="${book.nazwisko_autora}"/></td>
            <td><c:out value="${book.imiona_autora}"/></td>
            <td><c:out value="${fn:substring(book.data_wydania, 0, 10)}"/></td>
            <td><c:out value="${book.kategoria}"/></td>
            <td><form method="post" action="<c:out value="${delete_book}"/>"><input type="hidden" name="id" value="<c:out value="${book.id_ksiazki}"/>"/><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/><input type='submit' value='Usuń książkę'></form><br></td>
            </tr>
        </c:forEach>
        </table>
    </div>
</t:layoutAfterLogin>

<script type="text/javascript">
    function form_submit() {
        document.getElementById("new").submit();
    }
</script>