package org.mvpigs.ventanas.Inserts;

import org.mvpigs.SQL.MySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Nota extends JFrame{

    private JTextField maestro;
    private JTextField alumno;
    private JTextField asignatura;
    private JTextField nota;
    private JLabel infoMaestro;
    private JLabel infoAlumno;
    private JLabel infoAsignatura;
    private JLabel infoNota;
    private JButton insertBtn;
    private JLabel resultQuery;

    public Nota() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
        setVisible(true);
    }
    private void configurarVentana() {
        this.setTitle("Insertar Notas");                   // colocamos titulo a la ventana
        this.setSize(400, 450);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }
    private void inicializarComponentes() {

        infoMaestro = new JLabel();
        infoAlumno = new JLabel();
        infoAsignatura = new JLabel();
        infoNota = new JLabel();

        maestro = new JTextField();
        alumno = new JTextField();
        asignatura = new JTextField();
        nota = new JTextField();
        insertBtn = new JButton();
        resultQuery = new JLabel();

        infoMaestro.setText("ID Maestro:");
        infoMaestro.setBounds(10, 30, 150, 30);
        infoMaestro.setFont(new Font("Serif", Font.BOLD, 20));

        maestro.setBounds(10, 65, 200, 30);
        maestro.setFont(new Font("Serif", Font.BOLD, 20));

        infoAlumno.setText("ID Alumno:");
        infoAlumno.setBounds(10, 95, 150, 30);
        infoAlumno.setFont(new Font("Serif", Font.BOLD, 20));

        alumno.setBounds(10, 130, 200, 30);
        alumno.setFont(new Font("Serif", Font.BOLD, 20));

        infoAsignatura.setText("ID Asignatura:");
        infoAsignatura.setBounds(10, 160, 300, 30);
        infoAsignatura.setFont(new Font("Serif", Font.BOLD, 20));

        asignatura.setBounds(10, 195, 200, 30);
        asignatura.setFont(new Font("Serif", Font.BOLD, 20));

        infoNota.setText("Nota:");
        infoNota.setBounds(10, 225, 300, 30);
        infoNota.setFont(new Font("Serif", Font.BOLD, 20));

        nota.setBounds(10, 255, 200, 30);
        nota.setFont(new Font("Serif", Font.BOLD, 20));

        insertBtn.setText("Añadir");
        insertBtn.setBounds(250,90,100,100);

        resultQuery.setBounds(10,260,300,100);

        this.add(infoMaestro);
        this.add(maestro);
        this.add(infoAlumno);
        this.add(alumno);
        this.add(infoAsignatura);
        this.add(asignatura);
        this.add(infoNota);
        this.add(nota);
        this.add(insertBtn);
        this.add(resultQuery);


        //función de los botones
        insertBtn.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String maes = maestro.getText(); //Primera letra en mayúscula para evitar error
                String alu = alumno.getText();
                String asig = asignatura.getText();
                String not = nota.getText();

                String query = "insert into imparte (Maestro_idMaestro, Alumno_idAlumno, Asignatura_idAsignatura, nota) values "+
                        "('"+maes+"', '"+alu+"', '"+asig+"', '"+not+"')";
                query = query.toLowerCase();
                System.out.println(query);

                if(maestro.equals("") || alumno.equals("") || asignatura.equals("") || nota.equals("")){
                    resultQuery.setText("Rellena todos los campos");
                    resultQuery.setFont(new Font("Serif", Font.BOLD, 20));
                    resultQuery.setForeground(Color.RED);
                }
                else{
                    MySQL colegio = new MySQL();
                    try {
                        colegio.Insert(colegio, query);
                        resultQuery.setText("Nota añadida");
                        resultQuery.setFont(new Font("Serif", Font.BOLD, 20));
                        resultQuery.setForeground(Color.GREEN);
                        maestro.setText("");
                        alumno.setText("");
                        asignatura.setText("");
                        nota.setText("");

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
