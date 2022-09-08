package command_IF;

public class AlarmStartCommand implements Command {
	
	private Alarm theAlarm;
	
	AlarmStartCommand(Alarm theAlarm){
		this.theAlarm = theAlarm;
	}
	
	public void execute() {
		theAlarm.start();
	}
}
