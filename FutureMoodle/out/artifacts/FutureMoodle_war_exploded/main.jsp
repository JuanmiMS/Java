<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Controlador.Consultas" %>

<html>
<head>
    <title>Moodle 2.0</title>
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/estilo.css"/>
    <script src="Bootstrap/js/javascript.js"></script>
</head>
<body>
<%@ include file="utils/cookie.jsp" %>

<div id="main">
    <div class="top">
        <h2>HOLA <%=nombre%>
        </h2>
        <%@ include file="utils/lateralMenu.jsp" %>
    </div>

    <%
        Consultas co = new Consultas();
        ArrayList<String> asignaturas = co.getAsignaturas(dni);
        ArrayList<String> alumnos = co.getAlumnos(dni);
    %>
    <% for (String asignatura : asignaturas) {%>
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
                    <a href="mailto:<%=emailProfe%>" target="_top"><%=emailProfe%>
                    </a>
                </p>
            </div>
            <div class="trabajos">
                Aquí va la próxima tarea... :D
            </div>
        </div>
    </div>
    <% }%>

    <%if (nombre.contains("Profesor") || nombre.contains("Administrador")) {%>
        <% for (int i = 0; i < alumnos.size(); i++) {%>
         <div><%=alumnos.get(i)%></div>
         <% }%>
    <%}%>

</div>
</body>
</html>
