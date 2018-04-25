package org.foobarspam.furnaceDIP.hardware;

import org.foobarspam.furnaceDIP.interfaces.Heater;
import org.foobarspam.furnaceDIP.interfaces.Thermometer;
import org.foobarspam.furnaceDIP.interfaces.Regulate;
import org.foobarspam.furnaceDIP.types.RegulatorDisplayCodes;
import org.foobarspam.furnaceDIP.types.RoomTemperature;

public class Regulator implements Regulate {

	private Thermometer t;
	private Heater h;
	private double minTemp;
	private double maxTemp;
	private RoomTemperature temperature;
	RegulatorDisplayCodes code;

	public Regulator(Thermometer t, Heater h, double minTemp, double maxTemp, RoomTemperature temperature){
		this.t = t;
		this.h = h;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.temperature = temperature;
	}

	public void regulate() {
		while (t.read(temperature) < maxTemp) {
			this.code = RegulatorDisplayCodes.HEATING;
			h.engage(temperature);
			message();
		}
		while (t.read(temperature) > minTemp) {
			this.code = RegulatorDisplayCodes.WAITING;
			h.disengage(temperature);
			message();
		}
	}

	public void message() {
		switch (code) {
			case HEATING:
			System.out.println("Calentando => temperatura " + temperature.getTemperature());
				break;
			case WAITING:
				System.out.println("Apagado => temperatura " + temperature.getTemperature());
				break;
			default:
				System.out.println("Algo raro sucede...");
				break;
		}
	}
}
