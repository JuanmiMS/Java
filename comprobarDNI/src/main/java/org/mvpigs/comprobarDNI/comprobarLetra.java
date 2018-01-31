package org.mvpigs.comprobarDNI;

public class comprobarLetra{
    private char letra;
    private String dni;
    private char[] letras = {'T','R','W','A','G','M',
                    'Y','F','P','D','X','B',
                    'N','J','Z','S','Q','V',
                    'H','L','C','K', 'E'};

    //en caso de crear el objeto vacío
    public comprobarLetra(){
        this.letra = 'a';
        this.dni = "11111111";
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
    
}