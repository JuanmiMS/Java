package org.mvpigs.comprobardni;

import org.junit.*;
import junit.framework.TestCase;

public class testCheckDNI extends TestCase{
    @Test
    public void testCheckLetter(){
        //devuelve 'o' si da error
        checkDNI midni = new checkDNI("41540269");

        assertEquals('S', midni.getLetra());
        assertEquals('G', new checkDNI("47455398").getLetra());
        assertEquals('J', new checkDNI("49878779").getLetra());
        assertEquals('F', new checkDNI("26986850").getLetra());
        assertEquals('o', new checkDNI("asdasf").getLetra());
        assertEquals('M', new checkDNI("51871997").getLetra());
    }
}