package factory_method;

public class Clients {

	public static void main(String[] args) {
		
		ElevatorManager emWithRespnseTimeScheduler = 
				new ElevatorManager(2, SchedulingStrategyID.RESPONSE_TIME);
		emWithRespnseTimeScheduler.requestElevator(10, Direction.UP);
		
		
		ElevatorManager emWithThroughputScheduler = 
				new ElevatorManager(2, SchedulingStrategyID.THROUGHPUT);
		emWithRespnseTimeScheduler.requestElevator(1, Direction.DOWN);
	}

}
