package org.mvpigs.estacion;

import org.mvpigs.bicicleta.Bicicleta;
import org.mvpigs.tarjetaUsuario.TarjetaUsuario;

public class Estacion {

    private int id;
    private String direccion;
    private int numeroAnclajes;
    private Bicicleta[] anclajesLibres;

    /*Constructor*/
    public Estacion(int id, String direccion, int numeroAnclajes){
        this.id = id;
        this.direccion = direccion;
        this.numeroAnclajes = numeroAnclajes;
        anclajesLibres = new Bicicleta[numeroAnclajes];
    }

    /*Funciones*/
    public void consultarEstacion(){
        System.out.println("id: "+id);
        System.out.println("dirección: "+direccion);
        System.out.println("numeroAnclaje: "+numeroAnclajes);
    }

    public int anclajesLibres(){
        int total = 0;
        for (Bicicleta anclaje: anclajesLibres){

            if (anclaje == null){
                total++;
            }
        }
        return total;
    }

    public void anclarBicicleta(Bicicleta bici){

        int posicion = 0;
        int numeroAnclaje = posicion + 1;

        for (Bicicleta anclaje: anclajesLibres ){
            if ( anclaje == null ) {
                anclajesLibres[posicion] = bici;
                mostrarBicicletaAnclada(bici,  numeroAnclaje);
                break;
            }
            else
                posicion++;
                numeroAnclaje++;
        }
    }

    public void consultarAnclajes(){
        int posicion = 0;
        int numeroAnclaje = 0;

        for(Bicicleta bicicleta: anclajesLibres){
            numeroAnclaje = posicion + 1;
            if( bicicleta != null ){
                System.out.println("Anclaje " + numeroAnclaje + " " + anclajesLibres[posicion].getId());
            }
            else
                System.out.println("Anclaje " + numeroAnclaje + " " + " libre");

            posicion++;
        }
    }


    public boolean leerTarjetaUsuario(TarjetaUsuario tarjeta){
        return tarjeta.getActivada();
    }

    public void retirarBicicleta(TarjetaUsuario tarjeta){
        int posicion = 0;
        int numeroAnclaje = posicion + 1;

        if(tarjeta.getActivada()){
            for (Bicicleta anclaje: anclajesLibres ){
                if ( anclaje != null ) {
                    biciRetirada(anclajesLibres[posicion].getId(),  numeroAnclaje);
                    anclajesLibres[posicion] = null;
                    break;
            }
            else
                posicion++;
                numeroAnclaje++;
        }}

    }

    /*Métodos privados*/
    private void mostrarBicicletaAnclada(Bicicleta bici, int anclaje){
        System.out.println(bici.getId()+" anclada en el anclaje "+anclaje);
    }

    private void biciRetirada(int id, int anclaje){
        System.out.println("Bicileta retirada: "+id+" del anclaje: "+anclaje);
    }




    /* Getters y Setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAnclaje() {
        return numeroAnclajes;
    }

    public void setAnclaje(int numeroAnclajes) {
        this.numeroAnclajes = numeroAnclajes;
    }
}
