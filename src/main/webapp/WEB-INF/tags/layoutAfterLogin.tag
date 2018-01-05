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
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="/resources/css/layout.css">
    </head>
    <body>
        <header class="header">
            <div class="logo">
                <jsp:include page="/WEB-INF/jsp/logo.jsp" />
            </div>
            <jsp:include page="/WEB-INF/jsp/menuAfterLogin.jsp" />
        </header>

        <br>

        <div class="content">
            <jsp:doBody/>
        </div>
    </body>
</html>