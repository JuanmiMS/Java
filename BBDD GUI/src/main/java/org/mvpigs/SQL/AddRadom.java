package org.mvpigs.SQL;

import java.sql.SQLException;
import java.util.Random;
import java.security.SecureRandom;


/*NO TENER EN CUENTA ESTE CÓDIGO*/
//Se hizo únicamente para rellenar tablas de forma random sin ningún sentido
//Es un apaño rápido para no rellenar las tablas una a una.
// Tiempo usado: 1 token.

public class AddRadom {


    public AddRadom(){

    }

    public void alumnoAdd(String nom, String ape){
        MySQL alumno = new MySQL();
        String query = "insert into alumno (nombre, apellido) values "+
                "('"+nom+"', '"+ape+"')";
        System.out.println(query);

        try {
            alumno.Insert(alumno, query);
        } catch (SQLException e1) {
            e1.printStackTrace();

        }
    }
    public void maestroAdd(String nom, String ape){
        MySQL alumno = new MySQL();
        String query = "insert into maestro (nombre, apellido) values "+
                "('"+nom+"', '"+ape+"')";
        System.out.println(query);

        try {
            alumno.Insert(alumno, query);
        } catch (SQLException e1) {
            e1.printStackTrace();

        }
    }
    public void colegioAdd(String cif, String nom, String dir){
        MySQL alumno = new MySQL();
        String query = "insert into colegio (CIF, nombre, direccion) values "+
                "('"+cif+"', '"+nom+"', '"+dir+"')";
        System.out.println(query);

        try {
            alumno.Insert(alumno, query);
        } catch (SQLException e1) {
            e1.printStackTrace();

        }
    }
    public void asignaturaAdd(String[] asignaturas){

        String[] asig = asignaturas;


        for (int i = 0; i<asig.length; i++){
            MySQL alumno = new MySQL();
            String query = "insert into asignatura (nombre) values "+
                    "('"+asig[i]+"')";
            System.out.println(query);

            try {
                alumno.Insert(alumno, query);
            } catch (SQLException e1) {
                e1.printStackTrace();

            }
        }


    }

    public void imparteAdd(int maes, int alu, int asig, int not){
        MySQL alumno = new MySQL();
        String query = "insert into imparte (Maestro_idMaestro, Alumno_idAlumno, Asignatura_idAsignatura, nota) values "+
                "('"+maes+"', '"+alu+"', '"+asig+"', '"+not+"')";
        System.out.println(query);

        try {
            alumno.Insert(alumno, query);
        } catch (SQLException e1) {
            e1.printStackTrace();

        }
    }
    public static void main(String[] args) {

        int numeroInserts = 30;
        String[] nombres = {"Juan", "Miguel", "Andres", "Jaume", "Jaime", "Victor",
        "Valen", "Adrian", "Obi-wan", "Raul", "Cristina", "Antonia", "Ana", "Carmen"};
        String[] apellidos = {"Mari", "Sanchez", "Rivas", "Carmona","Dieguez", "Fuster",
        "Kenobi","Gonzalez", "Martinez", "Cuenca", "Ewok"};


        String[] asignaturas = {"Base de datos", "Programacion", "Sistemas digitales",
        "Lenguaje de marcas", "Fol"};


        String[] colegios = {"Borja Moll", "UOC", "Llado", "Sant Josep Obrer", "UIB"};
        String[] cifs = {"H50542505", "S2581635F", "C76682186", "D00745992", "W1909397J"};
        String[] calles = {"c/ Quinta calle", "c/ Manacor", "c/ Eusebi Estada", "c/ Bonaire", "c/ Ocells"};

        MySQL cone = new MySQL();
        AddRadom ran = new AddRadom();

        //ran.asignaturaAdd(asignaturas);


        for (int i = 0; i<numeroInserts; i++){
            int nom = (int) (Math.random() * nombres.length);
            int ape = (int) (Math.random() * apellidos.length);
            int asi = (int) (Math.random() * asignaturas.length);
            int col = (int) (Math.random() * colegios.length);
            int cif = (int) (Math.random() * cifs.length);
            int call = (int) (Math.random() * cifs.length);
            int mae = (int) (Math.random() * 30+1);
            int alu = (int) (Math.random() * 30+1);
            int asig = (int) (Math.random() * 5+1);
            int nota = (int) (Math.random() * 10+1);

            //ran.alumnoAdd(nombres[nom], apellidos[ape]);
            //ran.maestroAdd(nombres[nom], apellidos[ape]);
            //ran.imparteAdd(mae, alu, asig, nota);

            //Rompe por que los cifs aparecen duplicados
            //ran.colegioAdd(cifs[cif], colegios[col], calles[call]);


        }

    }
}
