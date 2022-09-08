package abstract_factory_pre;

public class LGDoor extends Door {


	@Override
	protected void doOpen() {
		System.out.println("LG Door Open");
	}

	@Override
	protected void doClose() {
		System.out.println("LG Door Close");
	}

}
