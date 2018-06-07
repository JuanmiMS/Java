package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.interfaces.TratamientoPedido;
import org.mvpigs.commandpattern.pedidos.PedidoInternacional;

public class TratamientoPedidoInternacional implements TratamientoPedido {

    private boolean seTrata;

    public TratamientoPedidoInternacional(PedidoInternacional pedidoInter){
        this.seTrata = !"Mordor".equals(pedidoInter.destino());
    }

    @Override
    public boolean tratar() {
        return this.seTrata;
    }
}
