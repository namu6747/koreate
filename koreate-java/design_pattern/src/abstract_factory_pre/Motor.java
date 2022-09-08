package abstract_factory_pre;

enum DoorStatus {
	OPEN, CLOSE
}

enum MotorStatus {
	MOVE, STOP
}

enum Direction {
	UP, DOWN
}

public abstract class Motor {
	private Door door;
	private MotorStatus motorStatus;

	public Motor() {
		this.motorStatus = MotorStatus.STOP;
	}

	public MotorStatus getMotorStatus() {
		return motorStatus;
	}

	private void setMotorStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}

	public void move(Direction direction) {
		if(this.getMotorStatus() == MotorStatus.MOVE) {
			System.out.println("Motor already running!");
		}
		if(door.getDoorStatus() == DoorStatus.OPEN) {
			door.close();
		}
		moveMotor(direction);
		setMotorStatus(MotorStatus.MOVE);
	}

	protected abstract void moveMotor(Direction direction);

	public void setDoor(Door door) {
		this.door = door;
	}
}
