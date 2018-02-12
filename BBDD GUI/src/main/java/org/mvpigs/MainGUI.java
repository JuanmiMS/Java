package org.mvpigs;

import org.mvpigs.SQL.MySQL;
import org.mvpigs.ventanas.Inserts.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainGUI extends JFrame implements ActionListener {

    private JLabel juanBench;
    private JLabel infoInsert;
    private JLabel infoQuery;
    private JTextField caja;
    private JButton boton;
    private JButton alumno;
    private JButton maestro;
    private JButton asignatura;
    private JButton colegio;
    private JButton nota;
    private JLabel bug;


    public MainGUI() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("MySQL JuanBench 0.0.1");                   // colocamos titulo a la ventana
        this.setSize(600, 630);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {

        // creamos los componentes
        juanBench = new JLabel();
        infoInsert = new JLabel();
        infoQuery = new JLabel();

        caja = new JTextField();
        boton = new JButton();

        alumno = new JButton();
        maestro = new JButton();
        colegio = new JButton();
        asignatura = new JButton();
        nota = new JButton();
        bug = new JLabel();

        // configuramos los componentes

        //BUGS
        bug.setText("BUG: Si la consulta solo tiene 2 columnas, da error. :(");
        bug.setBackground(Color.red);
        bug.setFont(new Font("Serif", Font.BOLD, 15));
        bug.setBounds(3, 40, 600, 40);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)


        //JuanBench (título)
        juanBench.setText("MySQL JuanBench");
        juanBench.setForeground(Color.gray);
        juanBench.setFont(new Font("Serif", Font.ITALIC, 30));
        juanBench.setBounds(3, 3, 300, 40);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)


        //Texto para ejecutar la query
        infoQuery.setText("Consulta:");
        infoQuery.setBounds(10, 470, 300, 30);
        infoQuery.setFont(new Font("Serif", Font.BOLD, 20));
        caja.setBounds(10, 500, 580, 32);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        caja.setFont(new Font("Serif", Font.BOLD, 20));

        //Botón para ejecutar la query
        boton.setText("Ejecutar Query");   // colocamos un texto al boton
        boton.setBounds(10, 535, 580, 50);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.setFont(new Font("Serif", Font.BOLD, 30));
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase

        //Botones para insert
        infoInsert.setText("INSERTS");
        infoInsert.setBounds(390, 300, 300, 50);
        infoInsert.setFont(new Font("Serif", Font.BOLD, 40));
        alumno.setText("Alumno");
        alumno.setBounds(370, 350, 100, 50);
        maestro.setText("Maestro");
        maestro.setBounds(480, 350, 100, 50);
        asignatura.setText("Asignatura");
        asignatura.setBounds(370, 410, 100, 50);
        colegio.setText("Colegio");
        colegio.setBounds(480, 410, 100, 50);
        nota.setText("Nota");
        nota.setBounds(375, 465, 200, 30);


        // adicionamos los componentes a la ventana
        this.add(juanBench);
        this.add(caja);
        this.add(boton);
        this.add(alumno);
        this.add(maestro);
        this.add(asignatura);
        this.add(colegio);
        this.add(nota);
        this.add(infoInsert);
        this.add(infoQuery);
        //this.add(bug);

        //función de los botones
        alumno.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 Alumno ventana = new Alumno();
             }
         }
        );
        maestro.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  Maestro ventana = new Maestro();
              }
          }
        );
        asignatura.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 Asignatura ventana = new Asignatura();
             }
         }
        );
        colegio.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {

              Colegio ventana = new Colegio();
          }
      }
        );
        nota.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {

                                          Nota ventana = new Nota();
                                      }
                                  }
        );

    }

        public void actionPerformed (ActionEvent e){
            String query = caja.getText();
            MySQL conexion = new MySQL();

            //Tranformamos la consulta a minúsculas
            query = query.toLowerCase();

            // obtenemos el contenido de la caja de texto
            //JOptionPane.showMessageDialog(this, "Hola " + nombre + ".");    // mostramos un mensaje (frame, mensaje)
            if (query.equals("alumnos")) {
                query = "select * from alumno";
                conexion.consulta(query);
            }
            else if (query.equals("maestros")) {
                query = "select * from maestro";
                conexion.consulta(query);
            }
            else if (query.equals("notas")) {
                query = "select * from imparte";
                conexion.consulta(query);
            }
            else if (query.equals("colegios")) {
                query = "select * from colegio";
                conexion.consulta(query);
            }
            else if (query.indexOf("insert") != -1) {
                JOptionPane.showMessageDialog(this, "Para " +
                        "utilizar INSERT, mejor aprovecha los botones especializados ;D");
            } else {
                MySQL select = new MySQL();

                select.consulta(query);

            }

        }

    public static void main(String[] args) {
        MainGUI bbdd = new MainGUI();      // creamos una ventana
        bbdd.setVisible(true);             // hacemos visible la ventana creada

    }

}