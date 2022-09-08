package factory_method;

public class ThroughputScheduler implements ElevatorScheduler{
	private static ThroughputScheduler throughputScheduler;
	
	private ThroughputScheduler() {};
	
	public static ElevatorScheduler getInstance() {
		if(throughputScheduler == null) {
			throughputScheduler = new ThroughputScheduler();
		}
		return throughputScheduler.getInstance();
	}

	@Override
	public int selectElevator(ElevatorManager manager, int destination, Direction direction) {
		return 0;
	}

}