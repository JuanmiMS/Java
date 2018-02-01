package org.mvpigs.comprobardni;

import org.junit.*;
import junit.framework.TestCase;
import java.util.ArrayList;

public class testCheckDNI extends TestCase {
    @Test
    public void testCheckLetter() {
        //devuelve 'o' si da error
        checkDNI midni = new checkDNI("41540269");
        assertEquals('S', midni.getLetra());
        assertEquals('e', new checkDNI("4745h398").getLetra());
        assertEquals('J', new checkDNI("49878779").getLetra());
        assertEquals('F', new checkDNI("26986850").getLetra());
        assertEquals('M', new checkDNI("51871997").getLetra());
    }

    @Test
    public void testRandomInvalidDNI() {

        //Generamos los DNI falsos y los metemos en una arraylist
        int cantidadDNI = 15;

        ArrayList<String> invalidDNI = new ArrayList<String>();

        for (int i = 0; i <= cantidadDNI; i++) {
            invalidDNI.add(new RandomDNI().getRandomDni());
        }

        //Comprobamos que son falsos
        for (int x = 0; x < invalidDNI.size(); x++) {
            assertEquals(false, new checkDNI(invalidDNI.get(x)).isValidDni());
            //System.out.println(invalidDNI.get(x) + "  " + new checkDNI(invalidDNI.get(x)).isValidDni());
        }

    }
}