package org.mvpigs.hardware;

import org.mvpigs.interfaces.Thermometer;
import org.mvpigs.types.RoomTemperature;

public class RemoteCommandSensor implements Thermometer {
	
	public double read(RoomTemperature temperature){
		return temperature.getTemperature();
	}

}
