package factory_method_inheritance;

public interface ElevatorScheduler {
	ElevatorManager manager = null;
	public default int selectElevator(ElevatorManager manager, int destination, Direction direction) {
		int selectedNum = (int)(Math.random()*5+1);
		return selectedNum;
	}
}
