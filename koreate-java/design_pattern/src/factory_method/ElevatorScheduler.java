package factory_method;

public interface ElevatorScheduler {
	public int selectElevator(ElevatorManager manager, int destination, Direction direction);
	
}
