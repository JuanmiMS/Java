package geometria;

import java.sql.SQLOutput;
import java.util.ArrayList;

//Aquí añadiremos las figuras
public class MainGeometria{
    public static void main(String[] args) {
        ArrayList<Figuras> figuras = new ArrayList<Figuras>();

        Cuadrado cuad1 = new Cuadrado(3);
        Circulo cic1 = new Circulo(5);
        System.out.println(cic1.area());

        
    }
}