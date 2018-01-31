package org.mvpigs.comprobardni;

public class checkDNI{
    private char letra;
    private String dni;
    private char[] letras = {'T','R','W','A','G','M',
                    'Y','F','P','D','X','B',
                    'N','J','Z','S','Q','V',
                    'H','L','C','K', 'E'};

    //Constructor
    public checkDNI(String dni){
        this.dni = dni;
        calcularLetra(dni);
    }

    //Getters y Setters
    public char getLetra(){
        return this.letra;
    }

    public void setLetra(String dni) {
		this.dni = dni;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
    }
    
    //Clases privadas
    private void calcularLetra(String dni){
        if(isNumeric(dni)){
            int number = Integer.parseInt(dni);
            this.letra = letras[calcularResto(number)];
        }
        else{
            System.out.print("El número dado no es un DNI");
        }
        
    }

    private int calcularResto(int suma){
        return suma%(letras.length);
    }

    private static boolean isNumeric(String caracter){
        try {
            Integer.parseInt(caracter);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
}
}