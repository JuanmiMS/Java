package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

//    private String USERNAME = "sql7239767";
//    private String PASSWORD = "l4clAhB3Ed";
//    private String HOST = "sql7.freemysqlhosting.net";
//    private String PORT = "3306";
//    private String DATABASE = "sql7239767";
//    private String CLASSNAME = "com.mysql.jdbc.Driver";
//    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
//    private Connection con;

    private String USERNAME = "root";
    private String PASSWORD = "1234";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "newmoodle";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    private Connection con;

    public ConexionMySQL() {
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR " + e);
        } catch (SQLException e) {
            System.out.println("ERROR " + e);
        }
    }

    public Connection getConexion() {
        return con;
    }

}