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
    public void testFactorial()
    {
        assertTrue("Falla test 1", 1 == SimpleExercices.factorial(0));
        assertTrue("Falla test 2", 6 == SimpleExercices.factorial(3));
        assertTrue("Falla test 3", 120 == SimpleExercices.factorial(5));
    }
}
