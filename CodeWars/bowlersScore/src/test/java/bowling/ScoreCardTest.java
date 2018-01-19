package bowling;

import bowling.ScoreCard;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreCardTest extends TestCase{
    
    ScoreCard scoreCard = new ScoreCard();

    @Test
    public void testGetSet(){

        String pins = "12345123451234512345";
		
		scoreCard.setScoreCard(pins);
		assertEquals("12345123451234512345", scoreCard.getScoreCard());
    }

    @Test
    public void testReturnTrue(){
        System.out.println("trueeee");
        assertEquals(scoreCard.returnTrue(), true);
    }
}