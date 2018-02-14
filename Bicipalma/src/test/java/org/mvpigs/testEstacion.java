package org.mvpigs;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mvpigs.bicicleta.Bicicleta;
import org.mvpigs.estacion.Estacion;
import static org.junit.Assert.assertEquals;

import org.mvpigs.*;
import org.mvpigs.tarjetaUsuario.TarjetaUsuario;

public class testEstacion{

    private Estacion est;

    @Before //No funciona
    public void crearEstaciones(){
        est = new Estacion(5, "Palma", 3);
    }

    @Test
    public void testConstructor(){
        assertEquals(est.getId(), 5);
        assertEquals(est.getDireccion(), "Palma");
        assertEquals(est.getAnclaje(), 3);
    }

    @Test
    public void testAnclajesLibres(){
        assertEquals(3, est.anclajesLibres());
    }

    //Caso test de David para testear todos los métodos y objetos
    @Test
    public void testAll(){
        Estacion estacion = new Estacion(1, "Manacor", 6);

        /* caso TEST visualizar estado de la estacion
         * muestra id, direccion, anclaje
         * */

        System.out.println("\n **** caso TEST visualizar estado de la estacion **** \n");

        estacion.consultarEstacion();

        /* caso TEST visualizar anclajes libres */

        System.out.println("\n **** caso TEST visualizar anclajes libres **** \n");

        System.out.println("anclajesLibres: " + estacion.anclajesLibres());

        /* caso TEST anclar bicicleta(s) */

        System.out.println("\n **** caso TEST anclar bicicleta(s) **** \n");

        int[] bicicletas = {291, 292, 293, 294};

		/* // generar anclaje random
		for (int i: bicicletas){
			System.out.println( estacion.generarAnclaje());
		}
		*/

        for ( int id: bicicletas ){
            Bicicleta bicicleta = new Bicicleta(id);
            estacion.anclarBicicleta(bicicleta);
        }

        System.out.println("anclajesLibres tras generar "+ bicicletas.length + " bicis: " + estacion.anclajesLibres());

        /* caso TEST consultar bicicletas ancladas */

        System.out.println("\n **** caso TEST consultar bicicletas ancladas **** \n");

        estacion.consultarAnclajes();

        /* caso TEST retirar bicicleta */

        System.out.println("\n **** caso TEST retirar bicicleta **** \n");

        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("000456789", true);

        System.out.println("¿tarjeta de usuario activada? (true/false): " + estacion.leerTarjetaUsuario(tarjetaUsuario) );

        estacion.retirarBicicleta(tarjetaUsuario);

        estacion.consultarAnclajes();

        System.out.println("anclajesLibres: " + estacion.anclajesLibres());
    }

}
