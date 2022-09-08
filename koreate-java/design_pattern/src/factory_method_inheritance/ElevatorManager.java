package factory_method_inheritance;

import java.util.ArrayList;
import java.util.List;

enum Direction{UP, DOWN};

public abstract class ElevatorManager {
	private List<ElevatorController> controllers;
	
	
	public ElevatorManager(int controllerCount){
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for(int i = 0; i<controllerCount; i++) {
			controllers.add(new ElevatorController(i+1));
		}
	}
	
	public void requestElevator(int destination, Direction direction) {
		ElevatorScheduler scheduler = getScheduler();
		int selectedElevator = scheduler.selectElevator(this,destination,direction);
		controllers.get(selectedElevator).gotoFloor(destination);
	}
	
	protected abstract ElevatorScheduler getScheduler();
	
}
