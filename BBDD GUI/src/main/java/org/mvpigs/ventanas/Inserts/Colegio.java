package org.mvpigs.ventanas.Inserts;

import org.mvpigs.SQL.MySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Colegio extends JFrame{

    private JTextField cif;
    private JTextField nombre;
    private JTextField direccion;
    private JLabel infoCif;
    private JLabel infoNombre;
    private JLabel infodireccion;
    private JButton insertBtn;
    private JLabel resultQuery;

    public Colegio() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
        setVisible(true);
    }
    private void configurarVentana() {
        this.setTitle("Insertar colegios");                   // colocamos titulo a la ventana
        this.setSize(400, 350);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }
    private void inicializarComponentes() {

        infoCif = new JLabel();
        infoNombre = new JLabel();
        infodireccion = new JLabel();

        cif = new JTextField();
        nombre = new JTextField();
        direccion = new JTextField();
        insertBtn = new JButton();
        resultQuery = new JLabel();

        infoCif.setText("CIF:");
        infoCif.setBounds(10, 30, 100, 30);
        infoCif.setFont(new Font("Serif", Font.BOLD, 20));

        cif.setBounds(10, 65, 200, 30);
        cif.setFont(new Font("Serif", Font.BOLD, 20));

        infoNombre.setText("Nombre:");
        infoNombre.setBounds(10, 95, 100, 30);
        infoNombre.setFont(new Font("Serif", Font.BOLD, 20));

        nombre.setBounds(10, 130, 200, 30);
        nombre.setFont(new Font("Serif", Font.BOLD, 20));

        infodireccion.setText("direccion:");
        infodireccion.setBounds(10, 160, 300, 30);
        infodireccion.setFont(new Font("Serif", Font.BOLD, 20));

        direccion.setBounds(10, 195, 200, 30);
        direccion.setFont(new Font("Serif", Font.BOLD, 20));

        insertBtn.setText("Añadir");
        insertBtn.setBounds(250,90,100,100);

        resultQuery.setBounds(10,220,300,100);

        this.add(infoCif);
        this.add(cif);
        this.add(infoNombre);
        this.add(infodireccion);
        this.add(nombre);
        this.add(direccion);
        this.add(insertBtn);
        this.add(resultQuery);


        //función de los botones
        insertBtn.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String Cif = cif.getText(); //Primera letra en mayúscula para evitar error
                String nom = nombre.getText();
                String dir = direccion.getText();
                String query = "insert into colegio (CIF, nombre, direccion) values "+
                        "('"+Cif+"', '"+nom+"', '"+dir+"')";
                query = query.toLowerCase();
                System.out.println(query);

                if(Cif.equals("") || dir.equals("") || nom.equals("")){
                    resultQuery.setText("Rellena todos los campos");
                    resultQuery.setFont(new Font("Serif", Font.BOLD, 20));
                    resultQuery.setForeground(Color.RED);
                }
                else{
                    MySQL colegio = new MySQL();
                    try {
                        colegio.Insert(colegio, query);
                        resultQuery.setText("Colegio "+nom+" añadido");
                        resultQuery.setFont(new Font("Serif", Font.BOLD, 20));
                        resultQuery.setForeground(Color.GREEN);
                        nombre.setText("");
                        direccion.setText("");
                        cif.setText("");

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        resultQuery.setText("Error del servidor");
                        resultQuery.setFont(new Font("Serif", Font.BOLD, 20));
                        resultQuery.setForeground(Color.RED);
                    }
                }





            } }
        );


    }
}
