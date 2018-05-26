package Servlet;
// Import required java libraries

import Controlador.Consultas;

import java.io.*;
import javax.servlet.http.*;

public class InicioSesion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("uname");
        String password = request.getParameter("pass");

        Consultas co = new Consultas();

        try {
            if(co.autenticacion(email, password)){

                Cookie user = new Cookie("usuario", co.getNameUser(email).replace(" ",""));
                user.setMaxAge(365*30*24*60*60);
                response.addCookie(user);
                response.sendRedirect("main.jsp");
            }
            else {
                System.out.println("not");
                response.sendRedirect("index.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}