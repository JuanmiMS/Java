package org.mvpigs.practicasteoria;
import java.util.Arrays;
import java.util.Random;

public class Ejercicio15 {

    public static void main(String[] args) {
        int[] vector = new int[30];
        Random aleatorio = new Random();

        for (int i = 0; i < vector.length; i++) {
            vector[i] = aleatorio.nextInt(20) + 1;
        }

        Arrays.sort(vector);
        for (int numero : vector) {
            System.out.println(numero);
        }
    }
}