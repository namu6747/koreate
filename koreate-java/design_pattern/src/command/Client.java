package command;

public class Client {
	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		Alarm alarm = new Alarm();
		Button btn = new Button(lamp, alarm);
		
		btn.setMode(Mode.LAMP);
		btn.pressed();
		btn.setMode(Mode.ALARM);
		btn.pressed();
	}
}
