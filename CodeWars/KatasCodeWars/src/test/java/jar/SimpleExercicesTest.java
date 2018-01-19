package jar;
import jar.SimpleExercices;

import org.junit.Test;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */


public class SimpleExercicesTest 
extends TestCase
{
    @Test
    public void testFactorial(){
        assertTrue("Falla test 1", 1 == SimpleExercices.factorial(0));
        assertTrue("Falla test 2", 6 == SimpleExercices.factorial(3));
        assertTrue("Falla test 3", 120 == SimpleExercices.factorial(5));
    }

    @Test
    public void testArrayPlusArray(){
        assertEquals(21, SimpleExercices.arrayPlusArray(new int[]{1,2,3}, new int[]{4,5,6}));
        assertEquals(-21, SimpleExercices.arrayPlusArray(new int[]{-1,-2,-3}, new int[]{-4,-5,-6}));
        assertEquals(15, SimpleExercices.arrayPlusArray(new int[]{0,0,0}, new int[]{4,5,6}));
        assertEquals(2100, SimpleExercices.arrayPlusArray(new int[]{100,200,300}, new int[]{400,500,600}));
    }
}
