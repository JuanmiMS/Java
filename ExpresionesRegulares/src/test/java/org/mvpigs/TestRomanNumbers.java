package org.mvpigs;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import static junit.framework.Assert.assertTrue;

public class TestRomanNumbers extends TestCase {

public static void testRomanToDecimal(){
    assertEquals(1182, RomanNumbers.romanToDecimal("MCLXXXII"));
    assertEquals(-1, RomanNumbers.romanToDecimal("MMMMCCCXII"));
    assertEquals(521, RomanNumbers.romanToDecimal("DXXI"));
    assertEquals(43, RomanNumbers.romanToDecimal("XLIII"));
    assertEquals(10, RomanNumbers.romanToDecimal("X"));
    assertEquals(-1, RomanNumbers.romanToDecimal(""));

}
}
