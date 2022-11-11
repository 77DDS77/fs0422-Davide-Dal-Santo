package com.davidedalsanto.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void sendAlertToObs() {
		this.getObservers().forEach(obs -> obs.update(this));
	}
	
	//default
	public void addObserver(Observer observer) {
		this.getObservers().add(observer);
	}
	
	public boolean removeObserver(Observer observer) {
		return this.getObservers().remove(observer);		
	}
}
