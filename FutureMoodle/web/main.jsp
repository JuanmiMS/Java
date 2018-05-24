<%--
  Created by IntelliJ IDEA.
  User: Winte
  Date: 24/05/2018
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.sql.*" %>
<html>
<head>
    <title>Moodle 2.0</title>
</head>
<body>
<h2>que pasha</h2>

<%
    String userid = request.getParameter("uname");
    String pwd = request.getParameter("pass");
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/futuremoodle",
                "root", "1234");
        Statement st = con.createStatement();
        ResultSet rs;
        rs = st.executeQuery("select * from users where uname='" + userid + "' and pass='" + pwd + "'");
        if (rs.next()) {
            session.setAttribute("userid", userid);
            //out.println("welcome " + userid);
            //out.println("<a href='logout.jsp'>Log out</a>");
            response.sendRedirect("success.jsp");
        } else {
            out.println("Invalid password <a href='index.jsp'>try again</a>");
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

%>
</body>
</html>
