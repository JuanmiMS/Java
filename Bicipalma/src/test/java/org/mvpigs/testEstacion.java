package org.mvpigs;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mvpigs.estacion.Estacion;
import org.mvpigs.tarjetaUsuario.TarjetaUsuario;

import static org.junit.Assert.assertEquals;

public class EstacionTest {
    @Before
    public void crearEstaciones(){
        Estacion estacion = new Estacion("");
        Estacion palma = new Estacion(1, "Plaza España", 8);
        TarjetaUsuario perico = new TarjetaUsuario("123456789, true");
    }

    @Test
    public void testComprobarEstacion() {

        assertEquals(0, estacion.getId());
        assertEquals(null, estacion.getDireccion());
        assertEquals(0, estacion.getNumeroAnclajes());
        assertEquals(null, estacion.getAnclajes());
    }

    @Test
    public void testComprobarEstacionConDatos() {
        System.out.println("[ " + palma.getId() + " ] " + palma.getDireccion() + " " + palma.getNumeroAnclajes());
        assertEquals(8, palma.getAnclajes().length);
    }

    @Test
    public void testConsultarEstacion() {
        System.out.println("**** CASO TEST VISUALIZAR ESTACION ****");

        palma.consultarEstacion();

    }

    @Test
    public void testConsultarAnclajesLibres() {
        System.out.println("**** CASO TEST VISUALIZAR ANCLAJES LIBRES ****");
        Estacion palma = new Estacion(1, "Plaza España", 8);
        System.out.println("anclajesLibres: " + palma.anclajesLibres());
        assertEquals(8, palma.anclajesLibres());
    }

    @Test
    public void testConsultarAnclajes() {
        System.out.println("**** CASO TEST VISUALIZAR ANCLAJES ****");
        Estacion manacor = new Estacion(1, "Manacor", 6);
        manacor.consultarAnclajes();
    }

    @Test
    public void testAnclarBicicleta() {
        Estacion manacor = new Estacion(1, "Manacor", 6);
        Bicicleta bici = new Bicicleta(291);
        manacor.anclarBicicleta(bici);
    }

    @Test
    public void testMostrarAnclaje() {
        System.out.println("**** CASO TEST VISUALIZAR ANCLAJES ****");
        Estacion olivar = new Estacion(2, "Plaza Olivar", 8);
        Bicicleta bicicleta = new Bicicleta(291);
        olivar.mostrarAnclaje(bicicleta, 1);
    }

    @Test
    public void testLeerTarjetaUsuarioInactiva() {
        TarjetaUsuario perico = new TarjetaUsuario("123456789");
        Estacion olivar = new Estacion(2, "Plaza Olivar", 8);
        assertEquals(false, olivar.leerTarjetaUsuario(perico));
    }

    @Test
    public void testLeerTarjetaUsuarioActiva() {
        TarjetaUsuario perico = new TarjetaUsuario("123456789, true");
        Estacion olivar = new Estacion(2, "Plaza Olivar", 8);
        assertEquals(true, olivar.leerTarjetaUsuario(perico));
    }

    @Test
    public void testRetirarBicicletaTarjetaInactiva() {
        Estacion olivar = new Estacion(2, "Plaza Olivar", 8);
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("123456789");
        olivar.retirarBicicleta(tarjetaUsuario);

    }

    @Test
    public void testRetirarBicicleta() {
        Estacion olivar = new Estacion(2, "Plaza Olivar", 8);
        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("123456789", true);

        // Debemos anclar bicicletas para poder retirarlas antes
        Bicicleta bici = new Bicicleta(291);

        olivar.anclarBicicleta(bici);
        olivar.retirarBicicleta(tarjetaUsuario);
    }

}