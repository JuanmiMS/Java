package org.mvpigs.cotxox.conductores;

import java.util.ArrayList;

public class Conductor {
    private String nombre;
    private String matricula;
    private String modelo;
    private ArrayList<Byte> valoraciones = new ArrayList<Byte>();


    public Conductor(String nombre){
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public void setValoracion(Byte valoracion) {
        this.valoraciones.add(valoracion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
