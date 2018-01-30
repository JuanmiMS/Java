package bowlers;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;

public class ScoreCardTest extends TestCase{

    public static void main(String[] args) {
        System.out.println("---------");
        new ScoreCard().recorrerScoreCard("12356");
        System.out.println("---------");

    }
    
    //Test final, se le pasa la scorecard y devuelve la puntuación total
    @Test
    public void testgetTotalPuntuation(){
        
        assertEquals(60, new ScoreCard("12345123451234512345").getTotalPuntuation());
    }

    //Recorre la scorecard
    @Test
    public static void testrecorrerScoreCard(){
        assertEquals(-1, new ScoreCard().recorrerScoreCard(""));
        assertEquals(1, new ScoreCard().recorrerScoreCard("1"));
        System.out.print("manzana");
    }

}