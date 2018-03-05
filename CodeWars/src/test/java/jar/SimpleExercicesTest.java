package jar;
import jar.SimpleExercices;

import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleExercicesTest 
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

    @Test
    public void testisValid(){
        assertEquals("Should return true", true, SimpleExercices.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        assertEquals("Should return false", false, SimpleExercices.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
        assertEquals("Should return false", false, SimpleExercices.isValid(new char[] {'w'}));
        assertEquals("Should return false", false, SimpleExercices.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }

    @Test
    public void test() {
        assertEquals("aehrsty", SimpleExercices.longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", SimpleExercices.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", SimpleExercices.longest("inmanylanguages", "theresapairoffunctions"));
    }

}
