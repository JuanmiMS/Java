package factory;



public abstract class LavadoraFactory extends Lavadora {


    protected static Lavadora creaSuperior(){
        Lavadora lav = new LavadoraCargaSuperior();
        lav.ponerMandos();
        setToTrue(lav);
        return lav;
    }

    protected static Lavadora creaFrontal(){
        Lavadora lav = new LavadoraCargaFrontal();
        setToTrue(lav);
        return lav;
    }

    private static void setToTrue(Lavadora lav){
        lav.ponerMandos();
        lav.ponerTambor();
    }

    abstract protected Lavadora creaLavadora();
}
