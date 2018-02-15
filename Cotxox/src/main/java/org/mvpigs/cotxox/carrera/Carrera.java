package org.mvpigs.cotxox.carrera;
import org.mvpigs.cotxox.conductores.Conductor;
import org.mvpigs.cotxox.conductores.PoolConductores;

public class Carrera {

    private String tarjetaCredito;
    private String origen;
    private String destino;
    private double distancia = 0d;
    private float costeEsperado;
    private int tiempoEsperado;
    private float tiempoCarrera;
    private float costeTotal;

    private Conductor conductor;

    public void asignarConductor(PoolConductores conductores){

    }

    public Conductor getConductor(){
        return this.conductor;
    }

    public String getNombre{
        return getConductor().getNombre();
    }

    public Carrera(String tarjetaCredito){
        this.tarjetaCredito = tarjetaCredito;
    }

    public void setTiempoEsperado(int tiempoEsperado){
        this.tiempoEsperado = tiempoEsperado;
    }
    public int getTiempoEsperado(){
        return tiempoEsperado;
    }

    public String getTarjetaCredito(){
        return tarjetaCredito;
    }
    public void setOrigen(String origen){
        this.origen = origen;
    }
    public String getOrigen(){
        return origen;
    }

    public void setDestino(String destino){
        this.destino = destino;
    }

    public String getDestino(){
        return destino;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setCosteEsperado(float costeEsperado){
        this.costeEsperado = costeEsperado;
    }

    public float getCosteEsperado(){
        return this.costeEsperado;
    }


}
