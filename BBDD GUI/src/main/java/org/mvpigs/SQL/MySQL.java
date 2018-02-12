package org.mvpigs.SQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class MySQL extends JFrame{

    private Connection conn;

    private Connection getConn(){
        return this.conn;
    }
    private void setConn(Connection conn){
        this.conn = conn;
    }


    public MySQL() {

        super();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/school?"
                                                + "user=root&password=1234");
            setConn(conn);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    private void configurarVentana() {
        this.setTitle("consulta");                   // colocamos titulo a la ventana
        this.setSize(300, 300);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla         // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
        setVisible(true);
    }

    public void Insert(MySQL connection,String query) throws SQLException {

            conn = connection.getConn();
            Statement st = connection.getConn().createStatement();
            st.execute(query);
            conn.close();
    }

    public void consulta(String query){

        configurarVentana();

        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(tabla);

        this.add(scrollPane);

        if (conn != null) {
            Statement stmt = null;
            ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                if (stmt.execute(query)) {
                    rs = stmt.getResultSet();

                    ResultSetMetaData metaDatos = rs.getMetaData();

                    // Se obtiene el número de columnas.
                    int numeroColumnas = metaDatos.getColumnCount();


                    // Se crea un array de etiquetas para rellenar

                    //BUG POSIBLEMENTE AQUÍ
                    Object[] etiquetas = new Object[numeroColumnas];
                    System.out.println("----"+numeroColumnas);

                    // Se obtiene cada una de las etiquetas para cada columna
                    for (int i = 0; i < numeroColumnas; i++)
                    {
                        // Nuevamente, para ResultSetMetaData la primera columna es la 1.
                        etiquetas[i] = metaDatos.getColumnLabel(i+1);
                    }

                    modelo.setColumnIdentifiers(etiquetas);


                    while (rs.next())
                    {
                        // Se crea un array que será una de las filas de la tabla.
                        Object [] fila = new Object[3]; // Hay tres columnas en la tabla

                        // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                        for (int i=0;i<3;i++){
                            fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                        }
                        // Se añade al modelo la fila completa.
                        modelo.addRow(fila);
                    }
                }

            } catch (SQLException ex) {
                // handle any errors
                setVisible(false);
                JOptionPane.showMessageDialog(this, ex.getMessage());
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            } finally {

                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) {
                    } // ignore

                    rs = null;
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlEx) {
                    } // ignore

                    stmt = null;
                }

                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException sqlEx) {
                    } // ignore

                    conn = null;
                }
            }
        }
    }


}
