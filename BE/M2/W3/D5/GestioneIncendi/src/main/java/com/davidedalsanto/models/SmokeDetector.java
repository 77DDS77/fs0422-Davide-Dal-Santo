package com.davidedalsanto.models;

import com.davidedalsanto.utils.LogColor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmokeDetector extends Subject{

	private Long id;
	private Double latitude;
	private Double longitude;	
	private int smokeLevel;
	
	public Boolean detectFire() { 
		if(smokeLevel > 5) { 
			sendAlertToObs(); 
			return true;
		} else {
			LogColor.infoMessage("No Fire Detected | Smoke lvl: " + smokeLevel);
			return false;
		}
	}
}
