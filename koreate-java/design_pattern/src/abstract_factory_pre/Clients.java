package abstract_factory_pre;

enum Vendor { LG, HYUNDAI };

public class Clients {
	public static void main(String[] args) {
		String vendor = Vendor.LG.toString();
		
		ElevatorFactory factory = ElevatorFactoryFactory.getInstance(vendor);
		
		Door door = factory.createDoor();
		Motor motor = factory.createMotor();
		motor.setDoor(door);
		motor.getMotorStatus();
		door.open();
		motor.move(Direction.UP);
		
	}
}




/*
 * 구성품 중에서 모터와 문을 예로 든다
 * 제조 업체가 달라도 같은 동작을 지원해야함
 * 실제 객체로는 생성될 일이 없으므로
 * 모터와 문 자체는 추상 클래스로 정의했다.
*/
