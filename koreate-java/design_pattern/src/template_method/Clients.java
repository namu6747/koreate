package template_method;


public class Clients {
	public static void main(String[] args) {
		Door door = new Door();
		Motor hyundaiMotor = new HyundaiMotor(door);
		hyundaiMotor.move(Direction.UP);
		
	}
}

/* 
 * 엘리베이터 제어 시스템 모터 구동 기능
 * 문이 닫혀 있는지 조사가 필요함
 * 이동 중이라면 모터 구동 필요 없음
 * 사용자는 문을 열고 닫을 수 있다. 
*/
