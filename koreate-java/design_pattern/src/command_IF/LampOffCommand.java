package command_IF;

public class LampOffCommand implements Command{
	private Lamp theLamp;

	LampOffCommand(Lamp theLamp){
		this.theLamp = theLamp;
	}
	
	
	public void execute() {
		theLamp.turnOff();
	}
	

}
