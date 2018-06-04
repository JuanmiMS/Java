package Servlet;

import Controlador.Consultas;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrarUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String dni = request.getParameter("dni");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rango = request.getParameter("rango");

        //Asignaturas
        String prog = request.getParameter("prog");
        String llmm = request.getParameter("llmm");
        String ssii = request.getParameter("ssii");
        String bbdd = request.getParameter("bbdd");

        System.out.println(dni+"-"+name+"-"+email+"-"+password+"-"+rango+"-"+prog+"_"+llmm);


        Consultas co = new Consultas();
        co.registrarUser(dni,email,password,name, rango.equals("Alumno") ? 3 : 2);

        //Comprobamos si es alumno o profesor
        if(rango.equals("Alumno")){
            co.addAsignaturaAlumno(prog, llmm, ssii, bbdd);
        }
        else{
            //no hace nada, es profesor. Falta implementar
        }


    }


}
