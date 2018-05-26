<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.sql.*" %>
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
    String nombre ="";
    boolean foundCookie = false;


    for(int i = 0; i < cookies.length; i++) {
        Cookie c = cookies[i];
        if (c.getName().equals("user")) {
            nombre = c.getValue();
            foundCookie = true;
        }
    }

    if (!foundCookie){
        response.sendRedirect("index.jsp");
    }

%>
    <h2>INICIO CORRECTO</h2>
<h2>HOLA <%=nombre%></h2>

Asignatuas:

<%
    Consultas co = new Consultas();
    ArrayList<String> asignaturas = co.getAsignaturas();
%>
<div class="row">
<% for (String asignatura : asignaturas) {%>
    <a href="asignatura?name=<%=asignatura%>">
    <div class="col asignatura">
        <h3><%=asignatura%></h3>
    </div>
    </a>
</div>
<% }%>
</div>


</body>
</html>
