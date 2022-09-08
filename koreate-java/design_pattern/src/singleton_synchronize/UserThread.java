package singleton_synchronize;

public class UserThread extends Thread {

	public UserThread(String name) {
		super(name);
	}
	
//	public void run() {
//		Printer printer = Printer.getPrinter();
//		printer.print(Thread.currentThread().getName()+" printer using " + printer.toString()+".");
//	}
}
