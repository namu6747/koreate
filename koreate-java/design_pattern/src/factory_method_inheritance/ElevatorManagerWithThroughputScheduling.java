package factory_method_inheritance;

public class ElevatorManagerWithThroughputScheduling extends ElevatorManager{

	public ElevatorManagerWithThroughputScheduling(int controllerCount) {
		super(controllerCount);
	}

	@Override
	protected ElevatorScheduler getScheduler() {
		return ThroughputScheduler.getInstance();
	}

}
