package org.mvpigs.commandpattern.tratamientos;

import org.mvpigs.commandpattern.interfaces.Pedido;

import java.util.ArrayList;


public class TratamientoPedidoMultiple  {

    ArrayList<Pedido> pedidos = new ArrayList();
    private int totalBultos;
    private int totalPeso;


    public TratamientoPedidoMultiple(ArrayList pedidos) {
        this.pedidos = pedidos;
    }

    public void calcularTotalBultos(){
        for(Pedido pedido : pedidos){
            totalBultos++;
        }
    }
    
    public void calcularPesoTotal(){
        for(Pedido pedido : pedidos){
            this.totalPeso+=pedido.peso();
        }
    }

    public double getNumBultos() {
        return this.totalBultos;
    }

    public double getPesoTotal() {
        return this.totalPeso;
    }

    public boolean tratar() {
        if(this.getPesoTotal() > 0 && this.getNumBultos() == pedidos.size()){
            return true;
        }
        return false;
    }
}
