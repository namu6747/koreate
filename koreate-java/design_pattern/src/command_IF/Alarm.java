package command_IF;

public class Alarm {
	
	String name;
	
	Alarm(String name){
		this.name = name;
	}
	
	void start() {
		System.out.println(this.name + " start");
	}
}
