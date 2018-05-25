<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.sql.*" %>

<html>
<head>
    <title>Moodle 2.0</title>
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

</body>
</html>
