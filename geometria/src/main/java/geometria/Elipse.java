package geometria;

public class Elipse extends Figuras {
    private double ladoX = 0d;
    private double ladoY = 0d;
    private final double PI = Math.PI;

    public Elipse(double ladoX, double ladoY) {
        super();
        this.ladoX = ladoX;
        this.ladoY = ladoY;
    }


    public Elipse(String nombre, double ladoX, double ladoY) {
        super(nombre);
        this.ladoX = ladoX;
        this.ladoY = ladoY;
    }

    @Override
    public double area() {
        return getLadoX() * getLadoY() * PI;
    }

    //Getters y setters
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
}