package org.mvpigs.commandpattern.pedidos;

import org.mvpigs.commandpattern.interfaces.Pedido;

public class PedidoNacional implements Pedido {
    public PedidoNacional(String destino, int i) {
    }

    @Override
    public int peso() {
        return 0;
    }

    @Override
    public String destino() {
        return null;
    }
}
