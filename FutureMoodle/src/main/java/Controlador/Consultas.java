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

    public ArrayList getAsignaturas(){
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<String> asignaturas = new ArrayList<String>();

        try {
            String consulta = "SELECT * FROM asignaturas";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
//                System.out.println(rs.getString("nombre"));
                asignaturas.add(rs.getString("nombre"));
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }

        return asignaturas;
    }
    public String getNameUser(String email){
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select name from users where email=\'"+email+"\'";
            pst = getConexion().prepareStatement(consulta);
            System.out.println(consulta);
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

    public String getNombreProfesor(String asignatura){
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select users.name from users inner join asignaturas on asignaturas.profesor = users.dni where asignaturas.nombre = \'"+asignatura+"\'";
            pst = getConexion().prepareStatement(consulta);
            System.out.println(consulta);
            rs = pst.executeQuery();


            if (rs.next()){
                System.out.println("1");
                String valor = rs.getString("name");
                System.out.println("hey "+ valor);
                System.out.println("2");
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
            System.out.println(consulta);
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
    public static void main(String[] args) {
        Consultas co = new Consultas();
    }
}
