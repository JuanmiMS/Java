package Servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Asignatura extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("name"));
        System.out.println("hey");

        try {
            response.sendRedirect("asignatura.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
