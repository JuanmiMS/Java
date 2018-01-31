package org.mvpigs.comprobardni;

import org.junit.*;
import junit.framework.TestCase;

public class testCheckDNI extends TestCase{
    @Test
    public void testCheckLetter(){
        
        checkDNI midni = new checkDNI("41540269");
        checkDNI midniError = new checkDNI("44r");
        assertEquals('S', midni.getLetra());
        assertEquals('o', midniError.getLetra());
    }
}