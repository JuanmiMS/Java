package org.mvpigs.comprobardni;

public class checkDNI {
    private char letra;
    private String dni;
    private boolean validDni = false;
    private char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
            'H', 'L', 'C', 'K', 'E' };

    //Constructor
    public checkDNI(String dni) {
        //Comprueba si el DNI son números de la posición 0 a la 8
        if (isNumeric(dni.substring(0, 8))) {
            this.dni = dni;
            calcularLetra(dni);
        }
        //En caso de contener letra comprobará si es válido
        else {
            if(calcularDNI(dni)){
                validDni = true;
            }
            else{
                validDni = false;
            }
           //Se le asignará la letra e al dni inválido 
            this.letra = 'e';
        }

    }

    //Getters y Setters
    public char getLetra() {
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
    private char calcularLetra(String dni) {
        int number = Integer.parseInt(dni);
        this.letra = letras[calcularResto(number)];
        return letras[calcularResto(number)];
    }

    private int calcularResto(int dni) {
        return dni % (letras.length);
    }

    private boolean calcularDNI(String dni) {
        String num = dni.substring(0, 8);
        char letter = dni.charAt(8);

       // System.out.println(num);

        if ( letter == calcularLetra(num)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isNumeric(String caracter) {
        try {
            Integer.parseInt(caracter);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

	public boolean isValidDni() {
		return validDni;
	}
	public void setValidDni(boolean validDni) {
		this.validDni = validDni;
	}
}