package org.mvpigs.cotxox.carrera;

import org.mvpigs.cotxox.conductores.Conductor;
import org.mvpigs.cotxox.conductores.PoolConductores;
import org.mvpigs.cotxox.tarifa.Tarifa;

public class Carrera {
    private String tarjetaCredito;
    private String origen;
    private String destino;
    private double distancia;
    private int tiempoEsperadoMinutos;
    private double costeEsperado;
    private double costeTotal;
    private double propina;

    private Conductor conductor;

    //Constructor
    public Carrera(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public Conductor getConductor() {
        return conductor;
    }

    //Getters y setters
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public double getCosteEsperado() {
        return Tarifa.getCosteEsperado(this);
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getTiempoEsperado() {
        return tiempoEsperadoMinutos;
    }

    public void setTiempoEsperado(int tiempoEsperadoMinutos) {
        this.tiempoEsperadoMinutos = tiempoEsperadoMinutos;
    }

    public void asignarConductor(PoolConductores conductores) {
        setConductor(conductores.asignarConductor());
    }

    public void realizarPago(double pago) {
        this.costeTotal = pago;
    }

    public void recibirPropina(double propina) {
        this.propina = propina;
    }

    public void liberarConductor() {
        conductor.setOcupado(false);
    }

    public double getPropina() {
        return propina;
    }

    public void setPropina(double propina) {
        this.propina = propina;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }
}
