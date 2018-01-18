package jar;

import org.junit.platform.commons.annotation.Testable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;
import junit.*;

/**
 * Unit test for simple App.
 */


public class SimpleExercicesTest 
    extends TestCase
{
    public void testFactorial()
    {
        assertTrue("Falla test 1", 1 == SimpleExercices.factorial(0));
        assertTrue("Falla test 2", 6 == SimpleExercices.factorial(3));
        assertTrue("Falla test 3", 120 == SimpleExercices.factorial(5));

    }
}
