package factory_method_inheritance;

public class Clients {

	public static void main(String[] args) {

		ElevatorManager em = new ElevatorManagerWithDynamicScheduling(5);
		em.requestElevator(5, Direction.UP);
		em.requestElevator(5, Direction.UP);
		em.requestElevator(5, Direction.UP);
		em.requestElevator(5, Direction.UP);
		em.requestElevator(5, Direction.UP);
		em.requestElevator(5, Direction.UP);
		
			
		}

}
