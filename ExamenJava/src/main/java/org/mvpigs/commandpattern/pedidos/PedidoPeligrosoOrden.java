package org.mvpigs.commandpattern.pedidos;

import org.mvpigs.commandpattern.interfaces.PedidoPeligroso;

public class PedidoPeligrosoOrden implements PedidoPeligroso {

    private String instrucciones;
    private int peso;
    private String destino;

    public PedidoPeligrosoOrden(String destino, String instrucciones) {
    this.instrucciones = instrucciones;
    this.destino = destino;
    this.peso = 0;

    }


    @Override
    public String instrucciones() {
        return this.instrucciones;
    }

    @Override
    public int peso() {
        return this.peso;
    }

    @Override
    public String destino() {
        return this.destino;
    }
}
