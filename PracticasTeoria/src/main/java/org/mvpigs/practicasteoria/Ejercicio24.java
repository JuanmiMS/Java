package org.mvpigs.practicasteoria;

public class Ejercicio24 {

    public static void main(String[] args) {
        int[][] matriz = { { 2, 1, 3 }, 
                           { 1, 3, 4 }, 
                           { 7, 5, 6 } };       
        int mayor = 0;
        int menor = 0;
        int columna = 0;
        boolean silla = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matriz.length; i++) {

            //localizo el menor de una fila
            menor = matriz[i][0];
            columna = 0;
            for (int j = 1; j < matriz[i].length; j++) {
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    columna = j;
                }
            }

            //localizo el mayor de la columna donde esta el menor
            mayor = matriz[0][columna];
            for (int f = 0; f < 3; f++) {
                if (matriz[f][columna] > mayor) {
                    mayor = matriz[f][columna];
                }
            }

            if (mayor == menor) {
                silla = true;
System.out.println("el numero " + mayor
                        + " es un punto de silla, esta en la posicion: ("
                        + i + "," + columna + ")");
            }           
        }
        if (silla == false) {
            System.out.println("la matriz no tiene punto de silla");            
        }
    }
}