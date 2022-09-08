package abstract_factory_pre;

public class HyundaiMotor extends Motor{


	@Override
	protected void moveMotor(Direction direction) {
		System.out.println("Hyundai Motor Run");
	}

}
