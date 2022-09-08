package abstract_factory_pre;



public class ElevatorFactoryFactory {
	private static ElevatorFactory factory;
	public static ElevatorFactory getInstance(String vendor) {
		switch (vendor.toLowerCase()) {
		case "lg":
			factory = LGElevatorFactory.getInstance();
			break;
		case "hyundai":
			factory = HyundaiElevatorFactory.getInstance();
			break;
			
		}
		return factory;
	}
}
