package org.mvpig.estacion;

public class Estacion {
    private int id;
    private String direccion;
    private int anclaje;
    private boolean[] anclajeLibre;

    public Estacion(int id, String direccion, int anclaje){
        this.id = id;
        this.direccion = direccion;
        this.anclaje = anclaje;
        anclajeLibre = new boolean[anclaje];
    }


    public void consultarEstacion(){
        System.out.println("ID: "+this.id+
                        "\nDirección: " +this.direccion+
                        "\nAnclaje: "+ this.id);
    }

    public int anclajesLibres(){
        int total = 0;
        for (boolean temp : anclajeLibre){
            if(!temp){total++;}
        }
        return total;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAnclaje() {
        return anclaje;
    }

    public void setAnclaje(int anclaje) {
        this.anclaje = anclaje;
    }
}
