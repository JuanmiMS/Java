package org.mvpigs.cotxox.carrera;

public class Carrera {
    private String tarjetaCredito;
    private String origen;
    private String destino;
    private double distancia;
    private int tiempoEsperadoMinutos;

    //Constructor
    public Carrera(String origen, String destino, double distancia, int tiempoEsperadoMinutos){
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.tiempoEsperadoMinutos = tiempoEsperadoMinutos;
    }




}
