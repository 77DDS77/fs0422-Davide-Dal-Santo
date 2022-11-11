package com.davidedalsanto.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlCenter implements Observer{
	
	private Long id;
	private ComLine comLine = new ComLine();
	
	public ControlCenter(Long id) {
		this.id = id;
	}
	
	private void sendAlert(SmokeDetector sd) {
		comLine.sendCom(sd);
	}

	@Override
	public void update(Subject sd) {
		sendAlert((SmokeDetector)sd);
		
	}

	
}
