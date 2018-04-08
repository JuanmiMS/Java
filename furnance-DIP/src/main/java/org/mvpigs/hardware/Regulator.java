package org.mvpigs.hardware;

import org.mvpigs.interfaces.Heater;
import org.mvpigs.interfaces.Thermometer;
import org.mvpigs.types.RegulatorDisplayCodes;
import org.mvpigs.types.RoomTemperature;

public class Regulator {
	
	public void regulate(Thermometer t, Heater h, double minTemp, double maxTemp, RoomTemperature temperature) {
		RegulatorDisplayCodes code;
		while (t.read(temperature) < maxTemp) {
			code = RegulatorDisplayCodes.HEATING;
			h.engage(temperature);
			message(code, temperature);
		}
		while (t.read(temperature) > minTemp) {
			code = RegulatorDisplayCodes.WAITING;
			h.disengage(temperature);
			message(code, temperature);
		}
	}

	private void message(RegulatorDisplayCodes code, RoomTemperature temperature) {
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
