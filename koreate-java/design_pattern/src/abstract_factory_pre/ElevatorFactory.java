package abstract_factory_pre;

public abstract class ElevatorFactory {
	public abstract Motor createMotor();
	public abstract Door createDoor();
}
/*
 * 엘지 모터와 현대 모터는 각각 모터와 도어를 상속받고 있는데
 * 객체 생성에 대한 팩토리를 추가함으로써
 * 동일한 제조사의 부품을 간단히 사용할 수 있다
 * 하나의 공장으로 간단하게 부품 생성 가능
 * 마지막으로 각 팩토리들을 싱글턴 선언하면 됨.
 */
