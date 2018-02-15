package estacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import bicicleta.Bicicleta;
import sun.text.bidi.BidiLine;
import tarjetaUsuario.TarjetaUsuario;

public class Estacion {
	
	private int id 				 = 0; 
	private String direccion	 = null; 
	private int numeroAnclajes	 = 0;
	//private Bicicleta[] anclajes = null; // referencia a estructura datos anclajes, sea cual sea
	private Map<Integer, Bicicleta> anclajes = new HashMap<>();


	// pero la estructura ha de estar en su clase hardware anclajes por SRP:
	// la estación de divide en centralita = lógica y hardware anclajes que es la interfaz con el usuario/a.
	// Hard anclaje no es una capa de acceso a datos... pero casi ¿?
	// este diseño se ve influido por el diseño de la BBDD: entidades libro UML Quique
	
	/* CONSTRUCTOR */

	public Estacion(int id, String direccion, int anclajes) {
		
		this.id = id;
		this.direccion = direccion;
		this.numeroAnclajes = anclajes;
		//this.anclajes = new Bicicleta[anclajes];

		//Rellenamos los anclajes con null
		for(int i = 0; i< anclajes;i++){
			this.anclajes.put(i, null);
		}

	}

	
	public int getId() {
		return id;
	}


	public String getDireccion() {
		return direccion;
	}


	public int getNumeroAnclajes() {
		return numeroAnclajes;
	}

	/* LOGICA */
	
	public void consultarEstacion(){
		System.out.println("id: " + getId());
		System.out.println("direccion: " + getDireccion());
		System.out.println("numeroAnclajes: " + getNumeroAnclajes());
	}
	
	public int anclajesLibres(){
		
		int anclajesLibres = 0;
		
		for ( Bicicleta anclaje: anclajes.values()){
			// si el registro del array está en null => está libre
			if ( anclaje == null ){
				anclajesLibres++;
			}
			else;			
		}
		return anclajesLibres;
	}
	
	public void anclarBicicleta(Bicicleta bicicleta){
		//  insertar el objeto bicicleta en el primer registro libre del array
		
		int posicion = 0;
		int numeroAnclaje = posicion + 1;
		
		for (Bicicleta ancla: anclajes.values() ){
			if ( ancla == null ) { // leer anclaje

				anclajes.put(posicion, bicicleta);

				mostrarAnclaje(bicicleta,  numeroAnclaje);
				break;
			}
			else 
				posicion++;
				numeroAnclaje++;
		}
	}
	
	public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario){
		return tarjetaUsuario.getActivada();
	}
	
	public void retirarBicicleta(TarjetaUsuario tarjetaUsuario ){
		// genero un número de anclaje random = posicion en array
		// y retiro bici => poner a null
		
		if ( leerTarjetaUsuario(tarjetaUsuario) ){
			
			boolean biciRetirada = false;
			
			while( !biciRetirada ){
				
				int posicion = generarAnclaje();
				int numeroAnclaje  = posicion + 1;


				if (anclajes.get(posicion) != null){ // leer anclaje
					mostrarBicicleta( anclajes.get(posicion), numeroAnclaje );

					anclajes.replace(posicion, null);	 // set anclaje


					biciRetirada = true;
				}
				else; // generamos nuevo número de anclaje;
			}
			
		}
		else
			System.out.println("Tarjeta de usuario inactiva :(");		
	}
	
	
	public void mostrarBicicleta(Bicicleta bicicleta, int numeroAnclaje){
		System.out.println("bicicleta retirada: " + bicicleta.getId() + " del anclaje: " + numeroAnclaje);
	}
	
	public void mostrarAnclaje(Bicicleta bicicleta, int numeroAnclaje){
		System.out.println("bicicleta: " + bicicleta.getId() + " anclada en el anclaje: " + numeroAnclaje);
	}
	
	public void consultarAnclajes(){
		// recorre el array anclajes y muestra el id de la bici anclada o si está libre
		
		int posicion = 0;
		int numeroAnclaje = 0;
		
		for(Bicicleta bicicleta: anclajes.values()){
			numeroAnclaje = posicion + 1;
			if( bicicleta != null ){
				System.out.println("Anclaje " + numeroAnclaje + " " + anclajes.containsKey(numeroAnclaje));
			}
			else
				System.out.println("Anclaje " + numeroAnclaje + " " + " libre");
			
			posicion++;	
		}
	}
	
	public int generarAnclaje(){ // a hardware anclaje
		Integer numeroEntero = ThreadLocalRandom.current().nextInt(0, anclajes.size());
		return numeroEntero;
	}
	
}
