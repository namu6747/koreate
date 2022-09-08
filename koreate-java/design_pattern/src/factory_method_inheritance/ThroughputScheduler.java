package factory_method_inheritance;

public class ThroughputScheduler implements ElevatorScheduler{
	
	private static ElevatorScheduler scheduler;
	private ThroughputScheduler() {}
	public static ElevatorScheduler getInstance() {
		if(scheduler == null) {		
			scheduler = new ThroughputScheduler();
		}
		return scheduler;
	}
}
