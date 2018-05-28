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
    String dni = "";
    boolean foundCookie = false;


    for (int i = 0; i < cookies.length; i++) {
        Cookie c = cookies[i];
        if (c.getName().equals("usuario")) {
            nombre = c.getValue();
        }
        if (c.getName().equals("dni")) {
            dni = c.getValue();
        }
    }

//    if (!foundCookie) {
//        response.sendRedirect("index.jsp");
//    }

%>
<h2>HOLA <%=nombre%>
</h2>
<%
    Consultas co = new Consultas();
    ArrayList<String> asignaturas = co.getAsignaturas(dni);
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
<div id="wrapper">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    Start Bootstrap
                </a>
            </li>
            <li>
                <a href="#">Dashboard</a>
            </li>
            <li>
                <a href="#">Shortcuts</a>
            </li>
            <li>
                <a href="#">Overview</a>
            </li>
            <li>
                <a href="#">Events</a>
            </li>
            <li>
                <a href="#">About</a>
            </li>
            <li>
                <a href="#">Services</a>
            </li>
            <li>
                <a href="#">Contact</a>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->
    <script>
        $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>

</div>

<div id="page-content-wrapper">
    <div class="container-fluid">
        <h1>Simple Sidebar</h1>
        <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
        <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
        <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
    </div>
</div>
</body>
</html>
