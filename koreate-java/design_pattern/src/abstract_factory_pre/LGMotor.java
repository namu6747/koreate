package abstract_factory_pre;

public class LGMotor extends Motor{


	@Override
	protected void moveMotor(Direction direction) {
		System.out.println("LG Motor Run");
	}
	
}
