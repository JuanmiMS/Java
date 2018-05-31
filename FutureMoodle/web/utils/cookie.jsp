<%--
  Created by IntelliJ IDEA.
  User: Winte
  Date: 31/05/2018
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    if (!"".equals(nombre) && !"".equals(dni)){
        foundCookie = true;
    }

    if(!foundCookie) {
        response.sendRedirect("index.jsp");
    }

%>
</body>
</html>
