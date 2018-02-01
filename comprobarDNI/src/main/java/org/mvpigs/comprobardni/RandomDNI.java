package org.mvpigs.comprobardni;

import java.util.Random;

public class RandomDNI{
    private String randomDni;

    public RandomDNI(){
        makeRandomDniNum();
        makeRandomDniLetter();
    }

	public String getRandomDni() {
		return randomDni;
	}

	private void setRandomDni(String randomDni) {
		this.randomDni = randomDni;
    }

    private void makeRandomDniNum(){
        String dniGenerated = "";
        Random rand = new Random();
        
        for (int i = 0; i<8;i++){
            int randomNum = rand.nextInt(9 + 1);
            dniGenerated +=randomNum;
        }
        setRandomDni(dniGenerated);
    }

    private void makeRandomDniLetter(){
        //cambiar: solo sacar las 4 letras i,ñ,o,u
        char[] lettersNotAllowed = {'I', 'Ñ','O','U'};
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 0) + 1) + 0;

        this.randomDni+=(char) lettersNotAllowed[randomNum];
    }
    




}