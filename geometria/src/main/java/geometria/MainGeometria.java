package geometria;

import java.util.ArrayList;

//Aquí añadiremos las figuras
public class MainGeometria {
    public static void main(String[] args) {
        ArrayList<Figuras> figuras = new ArrayList<Figuras>();

        //Constructores
        Circulo circuloL = new Circulo(5);
        Circulo circuloS = new Circulo("circulo", 6);

        Cuadrado cuadradoL = new Cuadrado(5);
        Cuadrado cuadradoS = new Cuadrado("cuadrado", 10);

        Rectangulo rectanguloL = new Rectangulo(3, 3);
        Rectangulo rectanguloS = new Rectangulo("rectangulo", 3, 7);

        Elipse elipseL = new Elipse(4, 5);
        Elipse elipseS = new Elipse("elipse", 5, 2);


        //Añadir a la arrayList los locales (con nombre)
        figuras.add(circuloS);
        figuras.add(cuadradoS);
        figuras.add(rectanguloS);
        figuras.add(elipseS);

        //Mostramos el nombre de las figuras con su diametro por pantalla
        for (Figuras figura : figuras) {
            System.out.println("Area del " + figura.getNombre() + " = " + figura.area());
        }
    }
}