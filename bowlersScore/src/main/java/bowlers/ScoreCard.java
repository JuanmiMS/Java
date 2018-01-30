package bowlers;

import java.lang.reflect.Array;

public class ScoreCard{

    public int total;
    private String scoreCard;
    private int turns = 0;
    private String[] plays;

    /*Inicializo*/  
    public ScoreCard() {
        this.total = 0;
        this.scoreCard = "";
    }
    public ScoreCard(String scoreCard) {
        this.total = 0;
        this.scoreCard = scoreCard;
    }
    
    /* getters y setters */
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

	public String getScoreCard() {
		return scoreCard;
	}
	public void setScoreCard(String scoreCard) {
		this.scoreCard = scoreCard;
    }

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}
    
    /*Privado*/
    //Se le pasa una puntuación y se le suma al total
    private void sumTotal(int point){
        this.total += point;
    }

    //Comprobará
    private void createPlay(String scorecard, int posActual){
        //Si ambos son números
        if(Character.isDigit(scorecard.charAt(posActual)) && Character.isDigit(scorecard.charAt(posActual+1))){
            char a = (char) scorecard.charAt(posActual);
            int b = Character.getNumericValue(a);
            char aa = (char) scorecard.charAt(posActual+1);
            int bb = Character.getNumericValue(aa);
            int suma = b+bb;
            String str = Integer.toString(suma);
            plays[turns] = (String) str;
        }
        else{
            
        }
    }


    //Recorre el string recibido
    public void recorrerScoreCard(String scoreCard){
        
        if (scoreCard.length() >= 0){ 
            
            for(int i = 0; i<scoreCard.length()-1;i++){

                createPlay(scoreCard, i);
                System.out.println("MEC:"+plays[0]);
            }
        }
    }

    /*Publico*/
    public int getTotalPuntuation(){
    
        setTotal(60);
        return getTotal();
    }

    
}