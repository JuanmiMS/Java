<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/estilo.css"/>
    <script src="../Bootstrap/js/javascript.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">

</head>
<body>


<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <%--<a href="#">About</a>--%>
    <%if ("Administrador".equals(nombre)) { %>
    <%--<%if (1==1) { %>--%>

    <button type="button" class="btn btn-success" onclick="window.location='registrar.jsp';">Añadir usuario</button>
        <button type="button" style="float: right" class="btn btn-danger">Borrar usuario</button>
    <% } %>

    <img style="width: 100%;" src="img/calendar.JPG">
</div>
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>

</body>
</html>
