package Servlet;
// Import required java libraries

import Controlador.ConexionMySQL;
import Controlador.Consultas;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InicioSesion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String usuario = request.getParameter("uname");
        String password = request.getParameter("pass");


        Consultas co = new Consultas();

        System.out.println(co.autenticacion(usuario, password)+" - 11");
        System.out.println(co.autenticacion("admin2@admin.com", "admin")+" - 22");

        //funciona a la inversa. WHY
        try {
            if(co.autenticacion(usuario, password)){
                System.out.println("ok");
                response.sendRedirect("index.jsp");

            }
            else {
                System.out.println("not");
                response.sendRedirect("main.jsp");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}