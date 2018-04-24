package factory;

public class LavadoraCargaFrontal extends LavadoraFactory {

     public LavadoraCargaFrontal() {
    	    this.tipoCarga = "frontal";
     }

     @Override
     public Lavadora creaLavadora(){
         return new LavadoraCargaFrontal();
     }
}
