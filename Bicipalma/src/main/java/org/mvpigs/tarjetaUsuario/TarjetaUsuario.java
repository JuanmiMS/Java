package org.mvpigs.tarjetaUsuario;

public class TarjetaUsuario {
    private String id;
    private boolean activada;

    public TarjetaUsuario(String id, boolean activada){
        this.id = id;
        this.activada = activada;
    }



    /*Getters y Setters*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getActivada() {
        return activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }
}
