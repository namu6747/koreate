package factory_method_inheritance;

public class ElevatorManagerWithResponseTimeScheduling extends ElevatorManager{

	public ElevatorManagerWithResponseTimeScheduling(int controllerCount) {
		super(controllerCount);
	}

	@Override
	protected ElevatorScheduler getScheduler() {
		return ResponseTimeScheduler.getInstance();
	}

}
