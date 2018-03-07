package org.mvpigs.cotxox.conductores;

import java.util.ArrayList;

public class Conductor {
    private String nombre;
    private String modelo;
    private String matricula;
    private double valoracionMedia;
    private ArrayList<Byte> valoraciones = new ArrayList<>();
    private boolean ocupado = false;

    public Conductor() {
    }

    public Conductor(String nombre) {
        this.nombre = nombre;
    }

    public double getValoracion() {
        return this.valoracionMedia;
    }

    public void setValoracion(byte valoracion) {
        valoraciones.add(valoracion);
        calcularValoracionMedia();
    }

    private double calcularValoracionMedia() {
        int sumaValoraciones = 0;
        for (byte valoracion : this.valoraciones) {
            sumaValoraciones += valoracion;
        }
        this.valoracionMedia = (double) sumaValoraciones / this.valoraciones.size();
        return this.valoracionMedia;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
