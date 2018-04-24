package factory;

public class LavadoraCargaSuperior extends LavadoraFactory {

    public LavadoraCargaSuperior() {
    	    this.tipoCarga = "superior";
    }

    @Override
    public Lavadora creaLavadora(){
        return new LavadoraCargaSuperior();
    }
}
