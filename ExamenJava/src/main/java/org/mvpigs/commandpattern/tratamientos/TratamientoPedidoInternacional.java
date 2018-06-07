package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.interfaces.TratamientoPedido;
import org.mvpigs.commandpattern.pedidos.PedidoInternacional;

public class TratamientoPedidoInternacional implements TratamientoPedido {

    private boolean seTrata;

    public TratamientoPedidoInternacional(PedidoInternacional pedidoInter){
        if("Mordor".equals(pedidoInter.destino())){
            this.seTrata = false;
        }
        else {
            this.seTrata = true;
        }
    }

    @Override
    public boolean tratar() {
        return this.seTrata;
    }
}
