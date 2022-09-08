package abstract_factory_pre;

public class HyundaiDoor extends Door {


	@Override
	protected void doOpen() {
		System.out.println("Hyundai Door Open");
	}

	@Override
	protected void doClose() {
		System.out.println("Hyundai Door Close");
	}

}
