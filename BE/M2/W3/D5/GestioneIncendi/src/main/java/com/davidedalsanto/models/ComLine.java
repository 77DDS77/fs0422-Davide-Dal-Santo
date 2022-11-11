package com.davidedalsanto.models;

import com.davidedalsanto.utils.LogColor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ComLine {

	//on a Micorservice project here is where i would send the cross
	//api call
	private static final String baseUrl = "http://localhost:8080/host/alarm";
	
	public void sendCom(SmokeDetector sd) {
		LogColor.warnMessage(
				"High smoke level on sensor: " + sd.getId()
				+ " |LAT: " + sd.getLatitude()
				+ " |LON: " + sd.getLongitude()
				+ " |SMOKE LVL: " + sd.getSmokeLevel()
				);
		
		if(sd.getSmokeLevel() >= 5) {
			LogColor.infoMessage("SENDING ALERT MESSAGE.");
			//uri for the API call
			LogColor.warnMessage(
					baseUrl 
					+ "?=idDetector=" + sd.getId()
					+ "&lat=" + sd.getLatitude()
					+ "&lon=" + sd.getLongitude()
					+ "&smokelevel=" + sd.getSmokeLevel()
					);
		}
	}
}
