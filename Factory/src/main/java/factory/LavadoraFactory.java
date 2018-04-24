package factory;



public abstract class LavadoraFactory extends Lavadora {


    protected static Lavadora creaSuperior(){
        Lavadora lav = new LavadoraCargaSuperior();

        lav.tieneMandos = true;
        lav.tieneTambor = true;

        return lav;
    }

    protected static Lavadora creaFrontal(){
        Lavadora lav = new LavadoraCargaFrontal();

        lav.tieneMandos = true;
        lav.tieneTambor = true;

        return lav;
    }



//    abstract protected Lavadora creaLavadora();
}
