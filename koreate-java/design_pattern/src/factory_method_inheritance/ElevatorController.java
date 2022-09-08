package factory_method_inheritance;

public class ElevatorController {
	private int id;
	private int curFloor;
	
	ElevatorController(int id){
		this.id = id;
		this.curFloor = 1;
	}
	
	public void gotoFloor(int destination) {
		System.out.println("Elevator "+ id);
		this.curFloor = destination;
		System.out.println(" ==> "+ curFloor);
	}
	
}
