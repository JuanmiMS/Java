package org.mvpigs.commandpattern.procesadores;

import org.mvpigs.commandpattern.interfaces.Pedido;
import org.mvpigs.commandpattern.interfaces.Procesador;
import org.mvpigs.commandpattern.interfaces.TratamientoPedido;

public class Oficina implements Procesador {

    private String seTrata;

    @Override
    public boolean procesa(TratamientoPedido pedido) {
        this.seTrata = pedido.tratar() ? "ACEPTADO" : "RECHAZADO";
        return pedido.tratar();
    }

    public String printarStatus(boolean procesa, Pedido pedido){
        return String.format("%s %s", pedido.destino(), seTrata);
    }
}
