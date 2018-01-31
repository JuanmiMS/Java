package geometria;

public abstract class Figuras{
    
    private String nombre;
    
	public String getNombre() {
        return this.nombre;
	}
    
	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Figuras(){
        this.nombre = "desconocido";
    }

    public Figuras(String nombre){
        this.nombre = nombre;
    }
    
    public abstract double area();

}
