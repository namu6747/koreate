package ex_4_29.drive;

public abstract class Driver {
	String name;
	public abstract void drive();

}

class BusDriver extends Driver{
	
	@Override
	public void drive() {
		System.out.println(this.name+"님이 버스를 운전합니다.");
	}
		
	
}

class TaxiDriver extends Driver{

	public void drive() {
		System.out.println(this.name+"님이 택시를 운전합니다.");
	}
	
}