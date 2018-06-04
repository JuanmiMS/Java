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

    public ArrayList getAsignaturas(String user) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<String> asignaturas = new ArrayList<String>();

        try {
            String consulta;
            if (isAdmin(user)) {
                consulta = "select nombre from asignaturas";
            } else {
                consulta = "select asignaturas.nombre \n" +
                        "from asignaturas\n" +
                        "inner join AsignaturasAlumnos\n" +
                        "ON AsignaturasAlumnos.asignatura = asignaturas.id\n" +
                        "where AsignaturasAlumnos.alumno = \'" + user + "\'";

            }
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                asignaturas.add(rs.getString("nombre"));
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return asignaturas;
    }

    public String getNameUser(String email) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select name from users where email=\'" + email + "\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()) {
                String valor = rs.getString("name");
                return valor;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return "NONAME";
    }

    public String getDniUser(String email) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select dni from users where email=\'" + email + "\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()) {
                String valor = rs.getString("dni");
                return valor;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return "NONAME";
    }

    public String getNombreProfesor(String asignatura) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select users.name from users inner join asignaturas on asignaturas.profesor = users.dni where asignaturas.nombre = \'" + asignatura + "\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()) {
                String valor = rs.getString("name");
                return valor;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return "NONAME";
    }

    public String getEmailProfesor(String asignatura) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select users.email from users inner join asignaturas on asignaturas.profesor = users.dni where asignaturas.nombre = \'" + asignatura + "\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()) {
                String valor = rs.getString("email");
                return valor;
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return "NOMAIL";
    }

    public ArrayList getAlumnos(String profesor) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<String> alumnos = new ArrayList<String>();

        try {
            String consulta;
            if (isAdmin(profesor)) {
                consulta = "select nombre from asignaturas";
            } else {
                consulta = "select users.name, AsignaturasAlumnos.alumno from AsignaturasAlumnos\n" +
                        "inner join users\n" +
                        "on users.dni = asignaturasalumnos.alumno\n" +
                        "where users.dni = asignaturasalumnos.alumno\n" +
                        "and asignatura = (select id from asignaturas where profesor = '" + profesor + "' limit 1);";

            }
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                alumnos.add(rs.getString("name"));
            }

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        System.out.println(alumnos);
        return alumnos;
    }

    private boolean isAdmin(String dni) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "select rango from users where dni=\'" + dni + "\'";
            pst = getConexion().prepareStatement(consulta);
            rs = pst.executeQuery();


            if (rs.next()) {
                String valor = rs.getString("rango");
                System.out.println("valor: " + valor);
                if ("1".equals(valor)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Error " + e);
        }
        return false;


    }

    public boolean registrarUser(String dni, String email, String password, String name, int rango) {

        PreparedStatement pst = null;
        try {
            String consulta = "insert into users (DNI, email, password, name, rango) values (?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, dni);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, name);
            pst.setInt(5, rango);

            if (pst.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("mec");
            e.printStackTrace();
        }

        return false;
    }

    public void addAsignaturaAlumno(String dni, String... args) {

        for (int i = 0; i < args.length; i++) {
            String asig = args[i];
            System.out.println("asig: "+asig+", ID: "+getBbddId(asig));
            PreparedStatement pst = null;
            if(args[i] != null) {
                try {
                    String consulta = "insert into AsignaturasAlumnos (alumno, asignatura, superada) values (?,?,?)";
                    pst = getConexion().prepareStatement(consulta);
                    pst.setString(1, dni);
                    pst.setInt(2, getBbddId(asig));
                    pst.setBoolean(3, false);
                    pst.executeUpdate();

                } catch (Exception e) {
                    System.out.println("mec22");
                    e.printStackTrace();
                }
            }
        }
    }

    private static int getBbddId(String name){
        if ("prog".equals(name)){
            return 1;
        }
        else if ("bbdd".equals(name)){
            return 2;
        }
        else if ("ssii".equals(name)){
            return 3;
        }
        else if ("llmm".equals(name)){
            return 4;
        }
        else{
            return 1;
        }

    }

    public static void main(String[] args) {
        Consultas co = new Consultas();
//        System.out.println(co.registrarUser("123456789A", "user2@user.com", "user", "Usuario Dos Prueba", 3));
       // co.addAsignaturaAlumno("hola", null, "hey");

        co.addAsignaturaAlumno("13123", "prog",null,"llmm",null);
    }
}
