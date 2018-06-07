package org.mvpigs.commandpattern.pedidos;

import org.mvpigs.commandpattern.interfaces.Pedido;
import java.util.UUID;

public class PedidoInternacional implements Pedido {

    private String destino;
    private int peso;
    private String id;

    public PedidoInternacional(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public int peso() {
        return this.peso;
    }

    @Override
    public String destino() {
        return this.destino;
    }

    public Object getId() {
        return this.id;
    }
}
