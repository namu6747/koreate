package factory_method;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

enum Direction { UP, DOWN };

public class ElevatorManager {
//	복수의 객체가 저장되므로 컬렉션을 이용한다
	private List<ElevatorController> controllers;
	private SchedulingStrategyID strategyID;
	
	
	public ElevatorManager(int controllerCount, SchedulingStrategyID strategyID) {
		controllers = new ArrayList<ElevatorController>(controllerCount);
		
//		주어진 controller의 수에 따라 각기 다른 id를 쥐어주며 즉시 리스트에 추가.
		for(int i = 0; i<controllerCount; i++) {
			ElevatorController controller = new ElevatorController(i+1);
			controllers.add(controller);
		}
		this.strategyID = strategyID;
	}
	
	public void setStrategyID(SchedulingStrategyID strategyID) {
		this.strategyID = strategyID;
	}
	
	public void requestElevator(int destination, Direction direction) {
		ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategyID);
		System.out.println(scheduler);
		int selectedElevator = scheduler.selectElevator(this, destination, direction);
		controllers.get(selectedElevator).gotoFloor(destination);
	}
	
	public List<ElevatorController> getControllers(){
		return controllers;
	}

	
	
}
