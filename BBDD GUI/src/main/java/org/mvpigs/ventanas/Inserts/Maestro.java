package org.mvpigs.ventanas.Inserts;

import org.mvpigs.SQL.MySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Maestro extends JFrame{

    private JTextField nombre;
    private JTextField apellido;
    private JLabel infoNombre;
    private JLabel infoApellido;
    private JButton insertBtn;
    private JLabel resultQuery;

    public Maestro() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
        setVisible(true);
    }
    private void configurarVentana() {
        this.setTitle("Insertar Maestros");                   // colocamos titulo a la ventana
        this.setSize(500, 200);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }
    private void inicializarComponentes() {
        infoNombre = new JLabel();
        infoApellido = new JLabel();
        nombre = new JTextField();
        apellido = new JTextField();
        insertBtn = new JButton();
        resultQuery = new JLabel();

        infoNombre.setText("Nombre:");
        infoNombre.setBounds(10, 30, 100, 30);
        infoNombre.setFont(new Font("Serif", Font.BOLD, 20));

        nombre.setBounds(10, 65, 150, 30);
        nombre.setFont(new Font("Serif", Font.BOLD, 20));

        infoApellido.setText("Apellido:");
        infoApellido.setBounds(170, 30, 300, 30);
        infoApellido.setFont(new Font("Serif", Font.BOLD, 20));

        apellido.setBounds(170, 65, 150, 30);
        apellido.setFont(new Font("Serif", Font.BOLD, 20));

        insertBtn.setText("Añadir");
        insertBtn.setBounds(350,30,100,100);

        resultQuery.setBounds(10,100,300,100);


        this.add(infoNombre);
        this.add(infoApellido);
        this.add(nombre);
        this.add(apellido);
        this.add(insertBtn);
        this.add(resultQuery);


        //función de los botones
        insertBtn.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nom = nombre.getText();
                String ape = apellido.getText();
                String query = "insert into Maestro (nombre, apellido) values "+
                        "('"+nom+"', '"+ape+"')";
                query = query.toLowerCase();
                System.out.println(query);

                if(nom.equals("") || ape.equals("")){
                    resultQuery.setText("Rellena todos los campos");
                    resultQuery.setFont(new Font("Serif", Font.BOLD, 20));
                    resultQuery.setForeground(Color.RED);
                }
                else{
                    MySQL Maestro = new MySQL();
                    try {
                        Maestro.Insert(Maestro, query);
                        resultQuery.setText("Maestro"+nom+" "+ape+"añadido");
                        resultQuery.setFont(new Font("Serif", Font.BOLD, 20));
                        resultQuery.setForeground(Color.GREEN);
                        nombre.setText("");
                        apellido.setText("");

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
