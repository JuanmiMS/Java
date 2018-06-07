package org.mvpigs.commandpattern.pedidos;

import org.mvpigs.commandpattern.interfaces.Pedido;

public class PedidoInternacional implements Pedido {

    private String destino;
    private int peso;

    public PedidoInternacional(String destino, int peso){
        this.destino = destino;
        this.peso = peso;

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
