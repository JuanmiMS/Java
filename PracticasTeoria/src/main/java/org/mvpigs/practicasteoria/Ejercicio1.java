package org.mvpigs.practicasteoria;
import java.util.Random;

public class Ejercicio1 {

    public static void main(String[] args) {

        int[] lista = new int[25];
        Random aleatorio = new Random();
        double[] auxiliar = new double[4];
        int sumaImpares = 0;
        int min = 0;

        // damos valores a lista
        for (int i = 0; i < lista.length; i++) {
            lista[i] = aleatorio.nextInt(26) + 25;
        }

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] % 2 == 0) {
                auxiliar[0]++;
            } else {
                auxiliar[1]++;
}
            if (i == 0) {
                min = lista[i];
            } else if (lista[i] < min) {
                min = lista[i];
            }
        }
        auxiliar[2] = sumaImpares / auxiliar[1];
        for (int i = 1; i <= min; i++) {
            auxiliar[3] += i;
        }

        for (int i = 0; i < lista.length; i++) {
            System.out.println("Posicion " + i + " de la lista =" + lista[i]);
        }
        System.out.println();

        System.out.println("Numero de elementos pares: " + auxiliar[0]);
        System.out.println("Numero de elementos impares: " + auxiliar[1]);
        System.out.println("Media impares: " + auxiliar[2]);
        System.out.println("Suma de lso enteros comprendidos entre 1 y el minimo de la lista: "
                        + auxiliar[3]);
    }

}