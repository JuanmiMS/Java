package org.mvpigs.commandpattern.pedidos;

import org.mvpigs.commandpattern.interfaces.PedidoPeligroso;
import java.util.UUID;

public class PedidoPeligrosoOrden implements PedidoPeligroso {

    private String instrucciones;
    private int peso;
    private String destino;
    private String id;

    public PedidoPeligrosoOrden(String destino, String instrucciones) {
        this.instrucciones = instrucciones;
        this.destino = destino;
        this.peso = 0;
        this.id = UUID.randomUUID().toString();

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

    public String getId() {
        return this.id;
    }
}
