package org.mvpigs;
import junit.framework.TestCase;
import org.junit.Test;
import org.mvpigs.cotxox.carrera.Carrera;


public class testCotxox extends TestCase{

    @Test
    public void testCot(){

        assertEquals(1,1);

        String tarjetaCredito = "4916119711304546";
        String origen = "Aeroport Son Sant Joan";
        String destino = "Magaluf";
        double distancia = 7.75;
        int tiempoEsperadoMinutos = 10;

        Carrera carrera = new Carrera(tarjetaCredito);
        carrera.setOrigen(origen);
        carrera.setDestino(destino);
        carrera.setDistancia(distancia);
        carrera.setTiempoEsperado(tiempoEsperadoMinutos);

        System.out.println("\n#####" + "\t Set Pickup: \t" + "#####\n");

        System.out.println("Visa: " + carrera.getTarjetaCredito());
        System.out.println("From: " + carrera.getOrigen());
        System.out.println("To: " + carrera.getDestino());
        System.out.println("Distance: " + carrera.getDistancia());

        System.out.println("\n#####" + "\t See your Cost: \t" + "#####\n");

        System.out.println("Visa: " + carrera.getTarjetaCredito());
        System.out.println("From: " + carrera.getOrigen());
        System.out.println("To: " + carrera.getDestino());
        System.out.println("Distance: " + carrera.getDistancia());
        System.out.println("Total: " + carrera.getCosteEsperado() + "€");
    }


}
