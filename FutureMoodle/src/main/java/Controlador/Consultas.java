package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Consultas extends ConexionMySQL {

    public boolean autenticacion(String email, String password) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "SELECT * FROM users where email = ? and password = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error " + e);
        }



        return false;
    }

    public ArrayList getAsignaturas(String user){
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<String> asignaturas = new ArrayList<String>();

        try {
            String consulta;
            if(isAdmin(user)){
                consulta = "select nombre from asignaturas";
            }
            else{
                consulta = "select asignaturas.nombre \n" +
                        "from asignaturas\n" +
                        "inner join AsignaturasAlumnos\n" +
                        "ON AsignaturasAlumnos.asignatura = asignaturas.id\n" +
                        "where AsignaturasAlumnos.alumno = \'"+user+"\'";

            }
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            System.out.println(consulta);
            while (rs.next()) {
                asignaturas.add(rs.getString("nombre"));
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        System.out.println(asignaturas);
        return asignaturas;
    }

    public String getNameUser(String email){
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select name from users where email=\'"+email+"\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()){
                String valor = rs.getString("name");
                return valor;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return "NONAME";
    }
    public String getDniUser(String email){
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select dni from users where email=\'"+email+"\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()){
                String valor = rs.getString("dni");
                return valor;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return "NONAME";
    }

    public String getNombreProfesor(String asignatura){
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select users.name from users inner join asignaturas on asignaturas.profesor = users.dni where asignaturas.nombre = \'"+asignatura+"\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()){
                String valor = rs.getString("name");
                return valor;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return "NONAME";
    }
    public String getEmailProfesor(String asignatura){
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select users.email from users inner join asignaturas on asignaturas.profesor = users.dni where asignaturas.nombre = \'"+asignatura+"\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()){
                String valor = rs.getString("email");
                return valor;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return "NOMAIL";
    }


    private boolean isAdmin(String dni){
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select rango from users where dni=\'"+dni+"\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()){
                String valor = rs.getString("rango");
                System.out.println("valor: "+valor);
                if("1".equals(valor)){
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return false;


    }

    public static void main(String[] args) {
        Consultas co = new Consultas();
    }
}
