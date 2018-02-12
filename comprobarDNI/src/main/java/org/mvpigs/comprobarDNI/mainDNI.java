package org.mvpigs.comprobardni;

public class mainDNI{
     
    public static void main( String[] args){
        
        /*checkDNI midni = new checkDNI("41540269");
        System.out.println("Letra: "+midni.getLetra());

        int cantidadDNI = 15;
        for (int i = 0; i<=cantidadDNI;i++){
            System.out.print(new RandomDNI().getRandomDni() + ", ");
        }*/

        System.out.println("¿Es válido?"+ new checkDNI("41540268").getLetra());



    }

    


}