package factory;



public abstract class LavadoraFactory extends Lavadora {


    protected static Lavadora creaSuperior(){
        Lavadora lav = new LavadoraCargaSuperior();

        setToTrue(lav);

        return lav;
    }

    protected static Lavadora creaFrontal(){
        Lavadora lav = new LavadoraCargaFrontal();

        setToTrue(lav);

        return lav;
    }

    private static void setToTrue(Lavadora lav){
        lav.tieneMandos = true;
        lav.tieneTambor = true;
    }


//    abstract protected Lavadora creaLavadora();
}
