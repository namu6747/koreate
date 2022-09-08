package template_method;

public class Door {
	private DoorStatus doorStatus;
	
	public Door() {
		closed();
	}
	
	public DoorStatus getDoorStatus() {
		return doorStatus;
	}
	
	public void opened() {
		doorStatus = DoorStatus.OPENED;
	}
	public void closed() {
		doorStatus = DoorStatus.CLOSED;
	}
}
