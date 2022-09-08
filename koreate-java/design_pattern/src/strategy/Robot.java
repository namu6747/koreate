package strategy;

public abstract class Robot {
	private String name;
	private MovingStrategy movingStrategy;
	private AttackStrategy attackStrategy;
	
	public Robot(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void move() {
		movingStrategy.move();
	}
	
	public void attack() {
		attackStrategy.attack();
	}
	
	public void setMovingStrategy(MovingStrategy movingStrategy) {
		this.movingStrategy = movingStrategy;
	}
	
	public void setAttackStrategy(AttackStrategy attackStrategy) {
		this.attackStrategy = attackStrategy;
		
	}

	@Override
	public String toString() {
		return "name: "+name;
	}
	
//	다양한 동작들이 추가될 때마다 OCP 원칙을 위배하지 않으려면
//	로봇의 자식 클래스들의 내용을 변경하면 안된다.
//	그래서 행위에대한 인터페이스 구조를 작성하고
//	메소드를 위임함으로써 OCP 원칙을 지켰다.

}
