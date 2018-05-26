<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Controlador.Consultas" %>

<html>
<head>
    <title>Moodle 2.0</title>
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/estilo.css"/>
</head>
<body>
<%


    Cookie[] cookies = request.getCookies();
    String nombre = "";
    boolean foundCookie = false;


    for (int i = 0; i < cookies.length; i++) {
        Cookie c = cookies[i];
        if (c.getName().equals("user")) {
            nombre = c.getValue();
            foundCookie = true;
        }
    }

    if (!foundCookie) {
        response.sendRedirect("index.jsp");
    }

%>
<h2>HOLA <%=nombre%>
</h2>
<%
    Consultas co = new Consultas();
    ArrayList<String> asignaturas = co.getAsignaturas();
%>
<% for (String asignatura : asignaturas) {%>
<%--<a href="asignatura.jsp?name=<%=asignatura%>">--%>
    <div id="cuadroAsig">
        <div id="cabezaAsig"><%=asignatura%>
        </div>
        <div id="cuerpoAsig">
            <div class="profile">
                <img src="img/default.png">
                <p>Nombre:
                <%String nombreProfe = co.getNombreProfesor(asignatura);%>
                <%=nombreProfe%>
                <br>
                Email:
                <%String emailProfe = co.getEmailProfesor(asignatura);%>
                <a href="mailto:<%=emailProfe%>" target="_top"><%=emailProfe%></a>
                </p>
            </div>
            <div class="trabajos">
                Aquí va la próxima tarea... :D
            </div>
        </div>
    </div>
<%--</a>--%>
<%--</a>--%>
<% }%>


</body>
</html>
