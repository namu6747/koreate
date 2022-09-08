package template_method;

public class HyundaiMotor extends Motor{
	public HyundaiMotor(Door door) {
		super(door);
	}

	@Override
	protected void moveMotor(Direction direction) {
		System.out.println("현대 모터 구동");
	}
	
}
/*
 * move 메서드를 템플릿 메서드라 부르고 
 * move 메서드에서 호출되면서 하위 클래스에서 
 * 오버라이드될 필요가 있는 moveMotor 메서드를
 * primitive 혹은 hook 메서드라고 부른다.
 */