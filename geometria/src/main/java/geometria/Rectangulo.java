package geometria;

public class Rectangulo extends Figuras{
    
    private double ladoX = 0d;
    private double ladoY = 0d;

    public Rectangulo(float ladoX, float ladoY){
        super();
        this.ladoX = ladoX;
        this.ladoY = ladoY;
    }

    public Rectangulo(String nombre, float ladoX, float ladoY){
        super(nombre);
        this.ladoX = ladoX;
        this.ladoY = ladoY;
    }

	public double getLadoX() {
		return ladoX;
	}

	public void setLadoX(double ladoX) {
		this.ladoX = ladoX;
	}

	public double getLadoY() {
		return ladoY;
	}

	public void setLadoY(double ladoY) {
		this.ladoY = ladoY;
    }
    
    @Override
    public double area(){
		return getLadoX()*getLadoY();
	}
}