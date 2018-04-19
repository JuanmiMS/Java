package org.foobarspam.furnaceDIP.types;

public class RoomTemperature {

    private double temperature = 0;

    private static RoomTemperature INSTANCE;

    private RoomTemperature() {
    }

    public synchronized static RoomTemperature getInstance() {
       if(INSTANCE == null){
           INSTANCE = new RoomTemperature();
       }
       return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void incrementTemperature(double increment) {
        this.temperature += increment;
    }

}
