package command_IF;

public class Button {
	private Command theCommand;
	
	public Button(Command theCommand){
		setCommand(theCommand);
	}
	
	public void pressed() {
		theCommand.execute();
	
	}
	
	public void setCommand(Command newCommand) {
		theCommand = newCommand;
	}
	
}
