package singleton_static;

public class UserThread extends Thread {

	public UserThread(String name) {
		super(name);
	}
	
	public void run() {
		Printer.print(Thread.currentThread().getName()+" printer using " +".");
	}
}
