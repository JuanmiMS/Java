package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.interfaces.Pedido;
import java.util.List;


public class TratamientoPedidoMultiple  {

    private List<Pedido> pedidos;
    private int totalBultos;
    private int totalPeso;


    public TratamientoPedidoMultiple(List pedidos) {
        this.pedidos = pedidos;
    }

    public void calcularTotalBultos(){
        for(Pedido pedido : pedidos) totalBultos++;
    }
    
    public void calcularPesoTotal(){
        for(Pedido pedido : pedidos) this.totalPeso += pedido.peso();
    }

    public double getNumBultos() {
        return this.totalBultos;
    }

    public double getPesoTotal() {
        return this.totalPeso;
    }

    public boolean tratar() {
        return this.getPesoTotal() > 0 && this.getNumBultos() == pedidos.size();
    }
}
