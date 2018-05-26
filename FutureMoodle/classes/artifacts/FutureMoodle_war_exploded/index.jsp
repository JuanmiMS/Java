<%--
  Created by IntelliJ IDEA.
  User: Winte
  Date: 24/05/2018
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>New Moodle 2.0</title>
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="Bootstrap/css/estilo.css"/>
</head>
<body>
<h2 style="align-content: center">Moodle 2.0</h2>
<div id="cuadro">
    <div id="cabeza">
        Iniciar Sesión
    </div>
    <div id="cuerpo">
        <form class="form-horizontal" action="iniciar" method="post">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" name="uname" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Contraseña</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" name="pass" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success pull-right">Iniciar sesión</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
