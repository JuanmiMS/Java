package org.mvpigs.interfaces;

import org.mvpigs.types.RoomTemperature;

public interface Thermometer {
	
	public double read(RoomTemperature temperature);
}
