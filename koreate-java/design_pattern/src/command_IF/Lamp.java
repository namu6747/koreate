package command_IF;

public class Lamp {
	String name;
	
	Lamp(String name){
		this.name = name;
	}
	
	void turnOn() {
		System.out.println(this.name + " turn on");
	}
	
	void turnOff() {
		System.out.println(this.name + " turn off");
	}
}
