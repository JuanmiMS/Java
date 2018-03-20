package org.mvpigs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumbers {

    private static boolean isValid(String s, String num){
        if (s == null || s.isEmpty() || !s.matches(num)){return false;}
        else {return true;}
    }

    public static int romanToDecimal(String s) {

        String validNum = "^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

        //Comprueba si el número romano entrado es válido
        if(!isValid(s, validNum))
            return -1;

        final Matcher matcher = Pattern.compile("M|CM|D|CD|C|XC|L|XL|X|IX|V|IV|I").matcher(s);
        final int[] decimalValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        final String[] romanNumerals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int result = 0;

        //Mientras siga encontrando..
        while (matcher.find())
            for (int i = 0; i < romanNumerals.length; i++)
                if (romanNumerals[i].equals(matcher.group(0)))
                    result += decimalValues[i];

        return result;
    }

    public static void main( String[] args ){
        String num = "MCLXXXII";
        System.out.println(RomanNumbers.romanToDecimal(num));

    }


}
