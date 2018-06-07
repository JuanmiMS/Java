package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.interfaces.PedidoPeligroso;
import org.mvpigs.commandpattern.interfaces.TratamientoPedido;

public class TratamientoPedidoPeligroso implements TratamientoPedido {

    private boolean seTrata;

    public TratamientoPedidoPeligroso(PedidoPeligroso pedido) {

        this.seTrata = !pedido.instrucciones().equals("no ponerselo en el dedo");
    }

    @Override
    public boolean tratar() {
        return this.seTrata;
    }
}
