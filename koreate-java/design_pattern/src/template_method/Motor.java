package template_method;

public abstract class Motor {
	protected Door door;
	private MotorStatus motorStatus;

	public Motor(Door door) {
		this.motorStatus = MotorStatus.STOPPED;
		this.door = door;
	};

	public MotorStatus getMotorStatus() {
		return motorStatus;
	}

	protected void setMotorStatus(MotorStatus motorStatus) {
		this.motorStatus = motorStatus;
	}
	
	protected abstract void moveMotor(Direction direction);
	
	
//  맞는 경우를 찾지 말고 아닌 경우를 먼저 나열하고 작동만 시키자
//	메소드가 종료되면 인스턴스 멤버는 제거되므로
//	복제품을 만들어 체크한다.
	public void move(Direction direction) {
		MotorStatus motorStatus = getMotorStatus();
		if(motorStatus == MotorStatus.MOVING) {
			return;
		}
		
		DoorStatus doorStatus = door.getDoorStatus();
		if(doorStatus == DoorStatus.OPENED) {
			door.closed();
		}
		moveMotor(direction);
		setMotorStatus(MotorStatus.MOVING);
	}
	
}

//if(getMotorStatus().equals(MotorStatus.MOVING)) {
//System.out.println("모터 구동 중");
//return;
//}
//if(door.getDoorStatus().equals(DoorStatus.OPENED)) {
//door.closed();
//moveHyundaiMotor(direction);
//setMotorStatus(MotorStatus.MOVING);
//}
//return;