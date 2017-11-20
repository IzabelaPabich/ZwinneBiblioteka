<%@tag description="Layout page" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="pl">
    <head>
        <meta charset="utf-8">
        <title>Biblioteka Zwinne</title>
        <meta name="description" content="Projekt na ZMZP">
        <meta name="author" content="Łukasz Baryczka, Piotr Bednarek, Jacek Wróblewski, Przemysław Staszyński, Izabela Pabich">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    </head>
    <body>
        <header>
            <div class="logo">
                <jsp:include page="/WEB-INF/jsp/logo.jsp" />
            </div>
            <div class="menu">
                <jsp:include page="/WEB-INF/jsp/menuBeforeLogin.jsp" />
            </div>
        </header>

        <div>
            <section>
                <jsp:doBody/>
            </section>
        </div>
    </body>
</html>