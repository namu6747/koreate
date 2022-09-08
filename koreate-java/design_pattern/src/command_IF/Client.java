package command_IF;

public class Client {
	
	public static void main(String[] args) {
		
	
	Lamp L1 = new Lamp("1번 램프");
	Command L1_on = new LampOnCommand(L1);
	Button btn = new Button(L1_on);
	btn.pressed();
	
	Command L1_off = new LampOffCommand(L1);
	btn = new Button(L1_off);
	btn.pressed();
	
	Alarm A1 = new Alarm("1번 알람");
	Command A1_on = new AlarmStartCommand(A1);
	btn = new Button(A1_on);
	btn.pressed();
	}
	
}
