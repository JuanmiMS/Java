package org.mvpigs;

import junit.framework.TestCase;
import org.junit.Test;
import org.mvpigs.*;
import org.mvpigs.estacion.Estacion;


public class testEstacion extends TestCase {

    @Test
    public static void testConstructor(){
        Estacion est = new Estacion(5, "Palma", 3);
        assertEquals(est.getId(), 5);
        assertEquals(est.getDireccion(), "Palma");
        assertEquals(est.getAnclaje(), 3);
    }
}
