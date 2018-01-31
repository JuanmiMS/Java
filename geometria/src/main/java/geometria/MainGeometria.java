package geometria;

import java.util.ArrayList;

//Aquí añadiremos las figuras
public class MainGeometria{
    public static void main(String[] args) {
        ArrayList<Figuras> figuras = new ArrayList<Figuras>();

        Cuadrado cuad1 = new Cuadrado(3);
        Circulo cic1 = new Circulo("circulo", 5);

        System.out.println(cuad1.area());
        System.out.println(cic1.area());

        figuras.add(cic1);

        for (Figuras figura : figuras){
			System.out.println("Area del " + figura.getNombre() + " = " + figura.area());
		}
    }
}