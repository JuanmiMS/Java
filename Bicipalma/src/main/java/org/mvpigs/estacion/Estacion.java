package org.mvpigs.estacion;

import org.mvpigs.bicicleta.Bicicleta;

public class Estacion {

    private int id;
    private String direccion;
    private int numeroAnclajes;
    private Bicicleta[] anclajesLibres;

    /*Constructor*/
    public Estacion(int id, String direccion, int numeroAnclajes){
        this.id = id;
        this.direccion = direccion;
        this.numeroAnclajes = numeroAnclajes;
        anclajesLibres = new Bicicleta[numeroAnclajes];
    }

    /*Funciones*/
    public void consultarEstacion(){
        System.out.println("id: "+id);
        System.out.println("dirección: "+direccion);
        System.out.println("numeroAnclaje: "+numeroAnclajes);
    }

    


    /* Getters y Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAnclaje() {
        return numeroAnclajes;
    }

    public void setAnclaje(int numeroAnclajes) {
        this.numeroAnclajes = numeroAnclajes;
    }
}
