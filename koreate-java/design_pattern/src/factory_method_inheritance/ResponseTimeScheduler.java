package factory_method_inheritance;

public class ResponseTimeScheduler implements ElevatorScheduler{
	private static ElevatorScheduler scheduler;
	private ResponseTimeScheduler() {}
	public static ElevatorScheduler getInstance() {
		if(scheduler == null) {		
			scheduler = new ResponseTimeScheduler();
		}
		return scheduler;
	}
}
