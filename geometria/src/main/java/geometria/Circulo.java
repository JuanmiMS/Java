package geometria;

public class Circulo extends Figuras{
    
    private double lado = 0d;
    private final double PI = Math.PI;
    
    public Circulo(float lado){
        super();
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    @Override
	public double area(){
		return Math.pow(getLado(), 2);
	}

	


}