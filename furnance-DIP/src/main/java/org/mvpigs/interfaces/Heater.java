package org.mvpigs.interfaces;

import org.mvpigs.types.RoomTemperature;

public interface Heater {
	
	public void engage(RoomTemperature temperature);
	public void disengage(RoomTemperature temperature);

}
