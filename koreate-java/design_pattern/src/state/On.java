package state;

public class On implements State{
	
	private static On on = new On();
	private On() {};
	
	public static On getInstance() {
		return on;
	}
	
	@Override
	public void on_button_pushed(Light light) {
		if(light.getState() instanceof On) {
			System.out.println("이미 켜져 있음");
		}
	}

	@Override
	public void off_button_pushed(Light light) {
		System.out.println("Light OFF");
		light.setState(Off.getInstance());
	}
	
}
