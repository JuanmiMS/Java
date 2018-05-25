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

    public static void main(String[] args) {
        Consultas co = new Consultas();
        System.out.println(co.autenticacion("admin@admin.com", "admin"));

        System.out.println(co.getAsignaturas());
    }
}
